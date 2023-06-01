
import { DISCOVERY_URL, AUTHORITY_URL } from "./constants.js";

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
        discoveryUrl: document.getElementById("discoveryUrl").value,
        authority: document.getElementById("authority").value
    });

    window.close();
}

function restoreDefaultOptions(e) {
    e.preventDefault();

    chrome.storage.local.set({
        discoveryUrl: DISCOVERY_URL,
        authority: AUTHORITY_URL
    });
    
    document.getElementById("discoveryUrl").value = DISCOVERY_URL;
    document.getElementById("authority").value = AUTHORITY_URL;
    document.getElementById("submit").disabled = false;
}

document.addEventListener("DOMContentLoaded", async () => {
    const { discoveryUrl, authority } = await chrome.storage.local.get(["discoveryUrl", "authority"]);
    
    document.getElementById("discoveryUrl").value = discoveryUrl || DISCOVERY_URL;
    document.getElementById("authority").value = authority || AUTHORITY_URL;

    const form = document.getElementById("form");
    
    form.addEventListener("input", validate);
    form.addEventListener("submit", saveOptions)
    form.addEventListener("reset", restoreDefaultOptions);
});