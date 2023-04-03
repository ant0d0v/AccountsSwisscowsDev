"use strict";

const DEFAULT_AUTHORITY = "https://accounts.dev.swisscows.com";
const CLIENT_ID = "swisscows.vpn";
const CLIENT_CREDENTIALS = "c3dpc3Njb3dzLnZwbjpzd2lzc2Nvd3N2cG5wYXNz";

function authenticate(authority, username, password) {
    let params = new URLSearchParams();
    params.append("client_id", CLIENT_ID);
    params.append("grant_type", "password");
    params.append("username", username);
    params.append("password", password);

    return fetch(`${authority || DEFAULT_AUTHORITY}/connect/token`, {
        method: "POST",
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Authorization': `Basic ${CLIENT_CREDENTIALS}`,
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: params
    }).then(response => response.json());
}

function validateAccessToken(authority, token) {
    return fetch(`${authority || DEFAULT_AUTHORITY}/connect/userinfo`, {
        method: "GET",
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Authorization': `Bearer ${token}`,
        }
    })
    .then(response => response.json())
    .then(userinfo => userinfo.hasOwnProperty("feature.vpn"))
    .catch(() => false);
}