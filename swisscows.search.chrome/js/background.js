const DEFAULT_HOST = "vpn.swisscows.com";
const DEFAULT_PORT = 8001;
const PROXY_BYPASS_LIST = [
    "<local>",
    "10.0.0.0/8",
    "172.16.0.0/12",
    "192.168.0.0/16",
    "*.swisscows.com"
];

const ICON_ACTIVE = { 
    path: {
        16: "/images/icon-16-green.png",
        32: "/images/icon-32-green.png"
    }
};

const ICON_INACTIVE = { 
    path: {
        16: "/images/icon-16-blue.png",
        32: "/images/icon-32-blue.png"
    }
};

const ICON_ERROR = {
    path: {
        16: "/images/icon-16-red.png",
        32: "/images/icon-32-red.png"
    }
};


chrome.storage.onChanged.addListener(function (changes, areaName) {
    if (areaName !== "local") return;
    
    // update browser's proxy settings
    // on toggle "enabled" state

    if (changes.hasOwnProperty("enabled")) {
        if (changes.enabled.newValue === true) {
            chrome.storage.local.get(["host", "port"], (options) => {
                const { host = DEFAULT_HOST, port = DEFAULT_PORT } = options;
                
                const proxySettings = { 
                    mode: "fixed_servers",
                    rules: {
                        proxyForHttp: {
                            scheme: "http",
                            host: host || DEFAULT_HOST,
                            port: port || DEFAULT_PORT
                        },
                        proxyForHttps: {
                            scheme: "http",
                            host: host || DEFAULT_HOST,
                            port: port || DEFAULT_PORT
                        },
                        bypassList: PROXY_BYPASS_LIST
                    }
                };

                chrome.proxy.settings.set({ value: proxySettings, scope: "regular" });
                chrome.browserAction.setIcon(ICON_ACTIVE);
            });
        } else {
            chrome.proxy.settings.clear({ scope: "regular" });
            chrome.storage.local.remove(["token", "token_expire"]);
            chrome.browserAction.setIcon(ICON_INACTIVE);
        }
    }

    if (changes.hasOwnProperty("invalid_credentials")) {
        if (changes.invalid_credentials.newValue === true) {
            chrome.browserAction.setIcon(ICON_ERROR);
        }
    }
});

chrome.proxy.onProxyError.addListener(function (e) {
    chrome.storage.local.get(["enabled"], (options) => {
        if (!options.enabled) return;

        // disable proxy if something went wrong        
        //chrome.storage.local.set({ enabled: false });        
        console.log("Proxy connection error", e);
    });
});


let pendingRequests = [];
const MAX_AUTH_TRIES = 3;

chrome.webRequest.onAuthRequired.addListener(function (details, callback) {
    if (details.statusCode != 407) {
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
    
    chrome.storage.local.get(["enabled", "authority", "username", "password", "token", "token_expire"], (options) => {
        let { enabled, username, password, authority, token, token_expire } = options;

        if (!enabled || !username || !password) {
            return callback({});            
        }

        // authenticate using Basic authentication scheme
        // return callback({
        //     authCredentials: { username: username, password: password }
        // });


        // if there is a valid token 
        // then use it to authenticate the proxy request
        if (token && token_expire > new Date().valueOf()) {
            return callback({ 
                authCredentials: { username: token, password: "bearer" }
            });
        }

        // otherwise request and save token
        else {
            authenticate(authority, username, password).then(response => {
                if (response.error) {
                    chrome.storage.local.set({ enabled: false, invalid_credentials: true });
                    chrome.storage.local.remove([ "token", "token_expire" ]);
                    
                    return callback({ cancel: true });
                }
                
                validateAccessToken(authority, response.access_token).then(result => {
                    if (!result) {
                        chrome.storage.local.set({ enabled: false, invalid_credentials: true });
                        chrome.storage.local.remove([ "token", "token_expire" ]);
                    
                        return callback({ cancel: true });
                    }

                    chrome.storage.local.set({
                        token: response.access_token,
                        token_expire: new Date().valueOf() + response.expires_in * 1000
                    });
        
                    return callback({ 
                        authCredentials: { username: response.access_token, password: "bearer" }
                    });
                });
            });
        }
    });    
}, { urls: ["<all_urls>"] }, ['asyncBlocking']);

chrome.webRequest.onCompleted.addListener(function (details) {
    let index = pendingRequests.indexOf(details.requestId);
    if (index >= 0) {
        pendingRequests = pendingRequests.filter(id => id !== details.requestId);
    }
}, { urls: ["<all_urls>"] });

chrome.webRequest.onErrorOccurred.addListener(function (details) {
    let index = pendingRequests.indexOf(details.requestId);
    if (index >= 0) {
        pendingRequests = pendingRequests.filter(id => id !== details.requestId);
    }
}, { urls: ["<all_urls>"] });


// TODO: switch to use worker activate_event
document.addEventListener("DOMContentLoaded", function () {
    chrome.storage.local.get(["enabled", "invalid_credentials"], (options) => {
        const { enabled, invalid_credentials } = options;

        if (invalid_credentials === true) {
            chrome.browserAction.setIcon(ICON_ERROR);
        } else if (enabled === false) {
            chrome.browserAction.setIcon(ICON_INACTIVE);
        }

        
        else if (enabled === true) {
            // TODO: check incognito mode 
            chrome.proxy.settings.get({ incognito: false }, (details) => {
                if (details.levelOfControl !== "controlled_by_this_extension") {
                    chrome.storage.local.set({ enabled: false });
                    return;
                }
   
                chrome.browserAction.setIcon(ICON_ACTIVE);
            });            
        }
    });    
});