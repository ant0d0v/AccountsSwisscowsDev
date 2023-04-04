"use strict";

function toggle() {
    chrome.storage.local.get("enabled", (options) => {
        if (!options.enabled) toggleOn();
        else toggleOff();
    });
}

function toggleOn() {
    chrome.storage.local.get(["username", "password", "invalid_credentials"], (options) => {
        const { username, password, invalid_credentials } = options;

        if (!username || !password || invalid_credentials === true) {
            toggleSettings(true);
            return;
        }

        chrome.storage.local.set({ enabled: true });
    });
}

function toggleOff() {
    chrome.storage.local.set({ enabled: false });
}


function onLogin(e) {
    e.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let error = document.getElementById("error");
    
    chrome.storage.local.get("authority", (options) => {
        const { authority } = options;

        // validate user credentials
        authenticate(authority, username, password).then(response => {
            if (response.error) {
                error.innerText = chrome.i18n.getMessage("invalid_credentials");
                return;
            }

            // validate user permissions
            validateAccessToken(authority, response.access_token).then(result => {
                if (!result) {
                    error.innerText = chrome.i18n.getMessage("feature_not_available");
                    return
                }
                            
                // save user credentials
                // to be used for proxy authentication
                chrome.storage.local.set({ 
                    username: username, 
                    password: password,
                    invalid_credentials: false,
                    enabled: false
                });
                
                error.innerText = "";
                document.getElementById("username").readOnly = true;
                document.getElementById("password").readOnly = true;
                document.getElementById("btn-submit").setAttribute("hidden", "hidden");
                document.getElementById("btn-reset").removeAttribute("hidden");
                document.getElementById("form-links").setAttribute("hidden", "hidden");
                toggleSettings(false);
                
            }).catch(() => {
                error.innerText = chrome.i18n.getMessage("something_wrong");
            });

        }).catch(() => {
            error.innerText = chrome.i18n.getMessage("something_wrong");
        });
    });
}

function onLogout(e) {
    document.getElementById("username").readOnly = false;
    document.getElementById("password").readOnly = false;
    document.getElementById("btn-submit").removeAttribute("hidden");
    document.getElementById("btn-reset").setAttribute("hidden", "hidden");
    document.getElementById("form-links").removeAttribute("hidden");

    chrome.storage.local.set({ invalid_credentials: false, enabled: false });
    chrome.storage.local.remove(["username", "password"]);
}


function toggleSettings(show) {
    let section = document.getElementById("section-settings");
    let btn = document.getElementById("btn-settings");

    if (typeof show !== "boolean") {
        show = section.hasAttribute("hidden");
    }
    
    if (show) {
        let sections = document.querySelectorAll(".section");
        Array.from(sections).forEach(section => section.setAttribute("hidden", "hidden"));
        let buttons = document.querySelectorAll(".footer .icon.button");
        Array.from(buttons).forEach(button => button.classList.remove("active"));

        section.removeAttribute("hidden");
        btn.classList.add("active");
    } else {
        let main = document.getElementById("main");
        main.removeAttribute("hidden");
        section.setAttribute("hidden", "hidden");        
        btn.classList.remove("active");
    }
}

function toggleInfo(show) {
    let section = document.getElementById("section-info");
    let btn = document.getElementById("btn-info");

    if (typeof show !== "boolean") {
        show = section.hasAttribute("hidden");
    }

    if (show) {
        let sections = document.querySelectorAll(".section");
        Array.from(sections).forEach(section => section.setAttribute("hidden", "hidden"));
        let buttons = document.querySelectorAll(".footer .icon.button");
        Array.from(buttons).forEach(button => button.classList.remove("active"));

        section.removeAttribute("hidden");
        btn.classList.add("active");
    } else {
        let main = document.getElementById("main");
        main.removeAttribute("hidden");
        section.setAttribute("hidden", "hidden")        
        btn.classList.remove("active");
    }
}


function bindEvents() {
    // main switch events
    document.getElementById("switch-toggle").addEventListener("click", toggle);
    document.getElementById("switch-label-on").addEventListener("click", toggleOn);
    document.getElementById("switch-label-off").addEventListener("click", toggleOff);

    // credentials form
    let form = document.getElementById("form")
    form.addEventListener("submit", onLogin);
    form.addEventListener("reset", onLogout);

    // footer buttons
    document.getElementById("btn-settings").addEventListener("click", toggleSettings);
    document.getElementById("btn-info").addEventListener("click", toggleInfo);
}

document.addEventListener("DOMContentLoaded", function () {
    chrome.storage.local.get(["enabled", "username", "password", "invalid_credentials"], (options) => {
        document.getElementById("switch").className = (!!options.enabled) ? "switch on" : "switch off";

        let username = document.getElementById("username");
        let password = document.getElementById("password");
        let btnSubmit = document.getElementById("btn-submit");
        let btnReset = document.getElementById("btn-reset");
        let formLinks = document.getElementById("form-links");

        if (options.username)
            username.value = options.username;
        if (options.password)
            password.value = options.password;

        if (!options.username || !options.password || options.invalid_credentials === true) {
            username.readOnly = false;
            password.readOnly = false;
            btnSubmit.removeAttribute("hidden");
            btnReset.setAttribute("hidden", "hidden");
            formLinks.removeAttribute("hidden");
        } else {
            username.readOnly = true;
            password.readOnly = true;
            btnSubmit.setAttribute("hidden", "hidden");
            btnReset.removeAttribute("hidden");
            formLinks.setAttribute("hidden", "hidden");
        }
    });

    let nodes = document.querySelectorAll('[data-i18n]');
    Array.from(nodes).forEach(node => {
        node.innerHTML = chrome.i18n.getMessage(node.dataset.i18n);
    });

    let version = document.getElementById("version");
    version.innerText = chrome.runtime.getManifest().version;

    bindEvents();
});

chrome.storage.onChanged.addListener(function (changes, areaName) {
    if (areaName !== "local") return;
    if (!changes.enabled) return;
    
    document.getElementById("switch").className = changes.enabled.newValue === true ? "switch on" : "switch off";
});