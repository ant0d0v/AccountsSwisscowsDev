import { authenticate, getUserInfo, validatePermissions, getServerConfiguration } from './api.js';
import { DEFAULT_HOST, DEFAULT_PORT, PROXY_BYPASS_LIST } from './constants.js';
import { ICON_ACTIVE, ICON_INACTIVE, ICON_ERROR } from './constants.js';

const MAX_AUTH_TRIES = 3;
let pendingRequests = [];

chrome.storage.onChanged.addListener(async (changes, areaName) => {
    if (areaName !== "local") return;
    
    // update browser's proxy settings on toggle "enabled" state
    if (changes.hasOwnProperty("enabled")) {
        if (changes.enabled.newValue === true) {
            const { host = DEFAULT_HOST, port = DEFAULT_PORT } = await chrome.storage.local.get(["host", "port"]);
                
            const proxySettings = { 
                mode: "fixed_servers",
                rules: {
                    proxyForHttp: { scheme: "http", host: host, port: port },
                    proxyForHttps: { scheme: "http", host: host, port: port },
                    bypassList: PROXY_BYPASS_LIST
                }
            };

            chrome.proxy.settings.set({ value: proxySettings, scope: "regular" });
            chrome.action.setIcon(ICON_ACTIVE);
        } else {
            chrome.proxy.settings.clear({ scope: "regular" });
            chrome.storage.local.remove(["token", "token_expire"]);
            chrome.action.setIcon(ICON_INACTIVE);
        }
    }

    // update browser's proxy settings on server change
    if (changes.hasOwnProperty("host") || changes.hasOwnProperty("port")) {
        const { enabled, host = DEFAULT_HOST, port = DEFAULT_PORT } = await chrome.storage.local.get(["enabled", "host", "port"]);
        if (!enabled) return;

        const newHost = changes.host?.newValue || host;
        const newPort = changes.port?.newValue || port;

        const proxySettings = { 
            mode: "fixed_servers",
            rules: {
                proxyForHttp: { scheme: "http", host: newHost, port: newPort },
                proxyForHttps: { scheme: "http", host: newHost, port: newPort },
                bypassList: PROXY_BYPASS_LIST
            }
        };

        chrome.proxy.settings.set({ value: proxySettings, scope: "regular" });
    }

    // update servers on discovery url change
    if (changes.hasOwnProperty("discoveryUrl")) {
        loadConfiguration();
    }

    // reset authenticated user on change authority
    if (changes.hasOwnProperty("authority")) {
        chrome.storage.local.set({ enabled: false });
        chrome.storage.local.remove(["user", "username", "password", "token", "token_expire"]);
    }

    // update extension icon on error
    if (changes.hasOwnProperty("invalid_credentials")) {
        if (changes.invalid_credentials.newValue === true) {
            chrome.action.setIcon(ICON_ERROR);
        }
    }
});

chrome.proxy.onProxyError.addListener(async (e) => {
    const { enabled } = await chrome.storage.local.get(["enabled"]);
    if (!enabled) return;

    // disable proxy if something went wrong        
    // chrome.storage.local.set({ enabled: false });        
    console.log("Proxy connection error", e);
});

chrome.webRequest.onAuthRequired.addListener(async (details, callback) => {
    if (!details.isProxy) {
        return callback({});
    }
    
    // track authentication requests, to avoid infinite authentication tries
    // in case if provided credentials were bad

    pendingRequests.push(details.requestId);
    if (pendingRequests.filter(id => id === details.requestId).length > MAX_AUTH_TRIES) {
        chrome.storage.local.set({ enabled: false, invalid_credentials: true });
        chrome.storage.local.remove([ "token", "token_expire" ]);
        
        return callback({ cancel: true });
    }


    // attach authorization credentials
    // when establishing a tunnel to the Swisscows proxy
    
    const options = await chrome.storage.local.get(["enabled", "authority", "username", "password", "token", "token_expire"]);
    const { enabled, username, password, authority, token, token_expire } = options;

    if (!enabled || !username || !password) {
        return callback({});            
    }


    // if there is a valid token 
    // then use it to authenticate the proxy request

    if (token && token_expire > new Date().valueOf()) {
        return callback({ 
            authCredentials: { username: token, password: "bearer" }
        });
    }

    // otherwise request and save token

    else {
        const { access_token, expires_in, error } = await authenticate(authority, username, password);

        if (error) {
            chrome.storage.local.set({ enabled: false, invalid_credentials: true });
            chrome.storage.local.remove([ "token", "token_expire" ]);
            
            return callback({ cancel: true });
        }
        
        const user = await getUserInfo(authority, access_token);
        const isValid = validatePermissions(user);

        if (!isValid) {
            chrome.storage.local.set({ enabled: false, invalid_credentials: true });
            chrome.storage.local.remove([ "token", "token_expire" ]);
        
            return callback({ cancel: true });
        }

        chrome.storage.local.set({
            token: access_token,
            token_expire: new Date().valueOf() + expires_in * 1000
        });

        return callback({ 
            authCredentials: { username: access_token, password: "bearer" }
        });
    }
}, { urls: ["<all_urls>"] }, ['asyncBlocking']);

chrome.webRequest.onCompleted.addListener((details) => {
    if (pendingRequests.includes(details.requestId)) {
        pendingRequests = pendingRequests.filter(id => id !== details.requestId);
    }
}, { urls: ["<all_urls>"] });
  
chrome.webRequest.onErrorOccurred.addListener((details) => {
    if (pendingRequests.includes(details.requestId)) {
        pendingRequests = pendingRequests.filter(id => id !== details.requestId);
    }
}, { urls: ["<all_urls>"] });


async function loadConfiguration() {
    const { discoveryUrl, host = DEFAULT_HOST, port = DEFAULT_PORT } = await chrome.storage.local.get(["discoveryUrl", "host", "port"]);
    
    let servers = await getServerConfiguration(discoveryUrl);    
    if (!servers?.length) {
        servers = PROXY_SERVERS;
    }

    const isKnownServer = servers.some(server => server.host === host && server.port === port);

    if (!isKnownServer) {
        const { host, port } = servers[0];
        
        await chrome.storage.local.set({ 
            host: host, 
            port: port, 
            enabled: false 
        });
    }

    await chrome.storage.local.set({ servers: servers });
}

async function initialize() {
    const { enabled, invalid_credentials } = await chrome.storage.local.get(["enabled", "invalid_credentials"]);

    if (invalid_credentials === true) {
        chrome.action.setIcon(ICON_ERROR);
    } else if (enabled === false) {
        chrome.action.setIcon(ICON_INACTIVE); 
    }

    else if (enabled === true) {
        // TODO: check incognito mode 
        const { levelOfControl } = await chrome.proxy.settings.get({ incognito: false });

        if (levelOfControl !== "controlled_by_this_extension") {
            chrome.storage.local.set({ enabled: false });
        } else {
            chrome.action.setIcon(ICON_ACTIVE);
        }
    }
}

chrome.runtime.onStartup.addListener(loadConfiguration);
chrome.runtime.onStartup.addListener(initialize);

loadConfiguration();
initialize();