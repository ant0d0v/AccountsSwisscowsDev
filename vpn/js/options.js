"use strict";

const DEFAULT_HOST = "vpn.swisscows.com";
const DEFAULT_PORT = 8000;
const DEFAULT_AUTHORITY = "https://accounts.swisscows.com";

function validate() {
    let inputs = document.querySelectorAll("input")
    let button = document.getElementById("submit");
    let isValid = true;

    inputs.forEach(input => {
        if (!input.checkValidity()) isValid = false;
    });

    button.disabled = (isValid) ? false : true;
}

function saveOptions(e) {
    e.preventDefault();

    chrome.storage.local.set({
        host: document.getElementById("host").value,
        port: document.getElementById("port").valueAsNumber,
        authority: document.getElementById("authority").value
    });

    window.close();
}

function restoreDefaultOptions(e) {
    e.preventDefault();

    chrome.storage.local.set({
        host: DEFAULT_HOST,
        port: DEFAULT_PORT,
        authority: DEFAULT_AUTHORITY
    });
    
    document.getElementById("host").value = DEFAULT_HOST;
    document.getElementById("port").value = DEFAULT_PORT;
    document.getElementById("authority").value = DEFAULT_AUTHORITY;
    document.getElementById("submit").disabled = false;
}

document.addEventListener("DOMContentLoaded", function () {
    chrome.storage.local.get(["host", "port", "authority"], (options) => {
        document.getElementById("host").value = options.host || DEFAULT_HOST;
        document.getElementById("port").value = options.port || DEFAULT_PORT;
        document.getElementById("authority").value = options.authority || DEFAULT_AUTHORITY;
    });

    let form = document.getElementById("form");
    
    form.addEventListener("input", validate);
    form.addEventListener("submit", saveOptions)
    form.addEventListener("reset", restoreDefaultOptions);
});