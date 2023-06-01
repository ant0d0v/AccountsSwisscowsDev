import { authenticate, getUserInfo, getConnectionInfo, validatePermissions } from './api.js';
import { PROXY_SERVERS, DEFAULT_HOST, DEFAULT_PORT } from './constants.js';

async function toggle() {
    const { enabled } = await chrome.storage.local.get("enabled");
    
    if (!enabled) 
        await toggleOn();
    else 
        await toggleOff();
}

async function toggleOn() {
    const { username, password, invalid_credentials } = await chrome.storage.local.get(["username", "password", "invalid_credentials"]);
    
    if (!username || !password || invalid_credentials === true) {
        toggleSettings(true);
        return;
    }

    await chrome.storage.local.set({ enabled: true });
}

async function toggleOff() {
    await chrome.storage.local.set({ enabled: false });
}

async function onChangeServer(e) {
    const option = e.currentTarget;
    const select = document.getElementById("current-server");
    const options = document.getElementById("servers-list");
    
    select.querySelector("span").innerHTML = option.innerHTML;
    select.querySelector(".chevron").classList.remove("open");
    options.classList.toggle("active");

    await chrome.storage.local.set({ 
        host: e.target.dataset.host, 
        password: e.target.dataset.port 
    });
}

async function onLogin(e) {
    e.preventDefault();
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const errorEl = document.getElementById("error");
    const form = document.getElementById("form");
    const submit = document.getElementById("btn-submit");
    const loader = document.getElementById("loader");

    if (validate()) {
        const { authority } = await chrome.storage.local.get("authority");

        // validate user credentials
        try { 
            submit.setAttribute("disabled", "disabled");
            loader.classList.add("active");
            
            const { access_token, expires_in, error } = await authenticate(authority, username, password);            
            if (error) {
                errorEl.innerText = chrome.i18n.getMessage("invalid_credentials");
                return;
            }

            // get user properties
            const user = await getUserInfo(authority, access_token);

            // validate user permissions
            const result = validatePermissions(user);
            if (!result) {
                errorEl.innerText = chrome.i18n.getMessage("feature_not_available");
                return;
            }
                        
            // save user credentials
            // to be used for proxy authentication
            await chrome.storage.local.set({
                user: user,
                username: username, 
                password: password,
                token: access_token,
                token_expire: new Date().valueOf() + expires_in * 1000,
                invalid_credentials: false,
                enabled: false
            });
            
            errorEl.innerText = "";
            document.getElementById("btn-submit").setAttribute("hidden", "hidden");
            document.getElementById("btn-reset").removeAttribute("hidden");
            toggleSettings(false);

            form.setAttribute("hidden", "hidden");
            document.getElementById("settings-title").innerText = "";
            // TODO: update avatar
            document.getElementById("user-email").innerText = username;
            document.getElementById("user-info").removeAttribute("hidden");
        } catch {
            errorEl.innerText = chrome.i18n.getMessage("something_wrong");
        } finally {
            submit.removeAttribute("disabled");
            loader.classList.remove("active");
        }
    }
}

async function onLogout(e) {
    const form = document.getElementById("form");

    form.removeAttribute("hidden");
    document.getElementById("btn-submit").removeAttribute("hidden");
    document.getElementById("btn-reset").setAttribute("hidden", "hidden");
    document.getElementById("user-info").setAttribute("hidden", "hidden");
    document.getElementById("settings-title").innerText = chrome.i18n.getMessage("settings_legend");

    await chrome.storage.local.set({ invalid_credentials: false, enabled: false });
    await chrome.storage.local.remove(["user", "username", "password"]);
}

function validate() {
    const username = document.getElementById("username")
    const error = document.getElementById("error-email");
    const errorIcon = document.getElementById("error-icon");
    const successIcon = document.getElementById("success-icon");
    const emailRegex = /\S+@\S+\.\S+/;
    
    if (!emailRegex.test(username.value)) {
        error.innerText = chrome.i18n.getMessage("invalid_email");
        errorIcon.removeAttribute("hidden");
        successIcon.setAttribute("hidden", "hidden");
        username.classList.add("invalid");

        return false;
    } else {
        error.innerText = "";
        successIcon.removeAttribute("hidden");
        errorIcon.setAttribute("hidden", "hidden");
        username.classList.remove("invalid");

        return true;
    } 
}

function togglePassword() {
    const password = document.getElementById("password");
    const openEyeIcon = document.getElementById("eye-icon");
    const hiddenEyeIcon = document.getElementById("eye-off-icon");

    const type = password.getAttribute("type") === "password" ? "text" : "password";
    password.setAttribute("type", type);

    if (type === "password") {
        openEyeIcon.classList.add("active");
        hiddenEyeIcon.classList.remove("active");
    } else {
        hiddenEyeIcon.classList.add("active");
        openEyeIcon.classList.remove("active");
    }
}

function toggleSettings(show) {
    const section = document.getElementById("section-settings");
    const btnSettings = document.getElementById("btn-settings");
    const btnBack = document.getElementById("btn-back");

    if (typeof show !== "boolean") {
        show = section.hasAttribute("hidden");
    }
    
    if (show) {
        let sections = document.querySelectorAll(".section");
        Array.from(sections).forEach(section => section.setAttribute("hidden", "hidden"));
        btnSettings.classList.add("hidden");
        btnBack.classList.remove("hidden");
        section.removeAttribute("hidden");
    } else {
        let main = document.getElementById("main");
        main.removeAttribute("hidden");
        section.setAttribute("hidden", "hidden");        
        btnSettings.classList.remove("hidden");
        btnBack.classList.add("hidden");
    }
}

async function updateServersInfo() {
    const options = await chrome.storage.local.get(["servers", "host", "port"]);
    const { servers = PROXY_SERVERS, host = DEFAULT_HOST, port = DEFAULT_PORT } = options;

    const serversList = document.getElementById("servers-list");
    const currentServer = document.getElementById("current-server");

    let current = servers.find(server => server.host === host && server.port === port);
    if (current) {
        let flag = current.country.toLowerCase().replace(/\s/g, "-");
        currentServer.querySelector("span").innerHTML = `<svg class="icon"><use xlink:href="images/icons.svg#${flag}"></use></svg> ${current.country}`;
    }

    while (serversList.firstChild) serversList.removeChild(serversList.lastChild);
    servers.forEach((server) => {
        let option = document.createElement("div");
        let flag = server.country.toLowerCase().replace(/\s/g, "-");

        option.className = "option";
        option.innerHTML = `<svg class="icon"><use xlink:href="images/icons.svg#${flag}"></use></svg> ${server.country}` +
            (server.isBeta ? '<span class="beta">BETA</span>' : '') +
            (server.isPremium ? '<span class="premium">PREMIUM</span>' : '');

        option.dataset.host = server.host;
        option.dataset.port = server.port;
        option.dataset.countryCode = server.countryCode;
        option.dataset.country = server.country;
        option.addEventListener("click", onChangeServer);

        serversList.appendChild(option);
    });
}

async function updateConnectionInfo() {
    const { enabled, token } = await chrome.storage.local.get(["enabled", "token"]);
    const { ipAddress, country } = await getConnectionInfo(enabled ? token : null);

    document.getElementById("ip-value").innerText = ipAddress;
    document.getElementById("location-value").innerText = country;
}

function bindEvents() {
    // main switch events
    document.getElementById("btn-toggle").addEventListener("click", toggle);

    // server select
    const select = document.getElementById("current-server");
    const options = document.getElementById("servers-list");
    
    select.addEventListener("click", (e) => {
        e.stopPropagation();
        options.classList.toggle("active");
        select.querySelector(".chevron").classList.add("open");
    });

    document.addEventListener("click", (event) => {
        const isClickInsideDropdown = event.target === options;
        const isClickOnDropdownButton = event.target === select;

        if (!isClickInsideDropdown && !isClickOnDropdownButton) {
            options.classList.remove("active");
            select.querySelector(".chevron").classList.remove("open");
        }
    });

    // credentials form
    const form = document.getElementById("form");
    const username = document.getElementById("username");

    form.addEventListener("submit", onLogin);    
    username.addEventListener("input", validate);
    document.querySelector(".toggle-pass").addEventListener("click", togglePassword);

    // footer buttons
    document.getElementById("btn-settings").addEventListener("click", toggleSettings);
    document.getElementById("btn-back").addEventListener("click", toggleSettings);
    document.getElementById("btn-reset").addEventListener("click", onLogout);
}


document.addEventListener("DOMContentLoaded", async () => {
    const options = await chrome.storage.local.get(["enabled", "username", "password", "invalid_credentials"]);

    const status = document.getElementById("connection-status");
    const form = document.getElementById("form");
    const btnSubmit = document.getElementById("btn-submit");
    const btnReset = document.getElementById("btn-reset");
    const btnToggle = document.getElementById("btn-toggle");

    // localization
    let nodes = document.querySelectorAll('[data-i18n]');
    Array.from(nodes).forEach(node => {
        node.innerHTML = chrome.i18n.getMessage(node.dataset.i18n);
    });

    // status
    if (!!options.enabled) {
        status.innerText = chrome.i18n.getMessage("connection_status_connected");
        status.classList.add("on");
        btnToggle.classList.add("on");
    } else {
        status.innerText = chrome.i18n.getMessage("connection_status_disconnected");
        status.classList.remove("on");
        btnToggle.classList.remove("on");
    }

    // credentials form
    if (!options.username || !options.password || options.invalid_credentials === true) {
        btnSubmit.removeAttribute("hidden");
        btnReset.setAttribute("hidden", "hidden");
    } else {
        form.setAttribute("hidden", "hidden");
        btnSubmit.setAttribute("hidden", "hidden");
        btnReset.removeAttribute("hidden");
        document.getElementById("settings-title").innerText = "";
        document.getElementById("user-email").innerText = options.username;
        document.getElementById("user-info").removeAttribute("hidden");
    }

    // TODO: update avatar

    // version
    const extensionVersion = chrome.runtime.getManifest().version;
    const version = document.getElementById("version");    
    version.innerText = `Version ${extensionVersion}`;

    updateServersInfo();
    updateConnectionInfo();
    bindEvents();
});

chrome.storage.onChanged.addListener(async (changes, areaName) => {
    if (areaName !== "local") return;
    
    if (changes.hasOwnProperty("enabled")) {
        const status = document.getElementById("connection-status");
        const btnToggle = document.getElementById("btn-toggle");
        
        if (changes.enabled.newValue === true) {
            status.innerText = chrome.i18n.getMessage("connection_status_connected");
            status.classList.add("on");
            btnToggle.classList.add("on");
        } else {
            status.innerText = chrome.i18n.getMessage("connection_status_disconnected");
            status.classList.remove("on");
            btnToggle.classList.remove("on");
        }

        setTimeout(() => updateConnectionInfo(), 300);
    }

    if (changes.hasOwnProperty("servers")) {
        updateServersInfo();
    }

    if (changes.hasOwnProperty("host") || changes.hasOwnProperty("port")) {
        const { enabled } = await chrome.storage.local.get("enabled");
        if (!enabled) return;

        setTimeout(() => updateConnectionInfo(), 300);
    }
});