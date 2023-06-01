import { DISCOVERY_URL, AUTHORITY_URL, CLIENT_ID, CLIENT_CREDENTIALS } from "./constants.js";

export function authenticate(authority, username, password) {
    let params = new URLSearchParams();
    params.append("client_id", CLIENT_ID);
    params.append("grant_type", "password");
    params.append("username", username);
    params.append("password", password);

    return fetch(`${authority || AUTHORITY_URL}/connect/token`, {
        method: "POST",
        cache: "no-cache",
        credentials: "include",
        headers: {
            "Authorization": `Basic ${CLIENT_CREDENTIALS}`,
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: params
    }).then(response => response.json());
}

export function getUserInfo(authority, token) {
    return fetch(`${authority || AUTHORITY_URL}/connect/userinfo`, {
        method: "GET",
        cache: "no-cache",
        credentials: "include",
        headers: {
            "Authorization": `Bearer ${token}`,
        }
    })
    .then(response => response.json());
}

export function validatePermissions(userinfo = null) {
    if (!userinfo)
        return false;

    return userinfo.hasOwnProperty("feature.vpn");
}

export function getConnectionInfo(token) {
    console.log("getConnectionInfo", token);

    return fetch('https://echo.swisscows.com/', {
        method: "GET",
        cache: "no-cache",
        headers: {
            "Proxy-Authorization": token ? `Bearer ${token}` : null
        }
    })
    .then(response => response.json())
    .then(response => {
        let ipAddress = response.headers['x-real-ip'];
        let country = response.headers['geoip-country-name'];

        // if IP address is in the 172.16.0.0/12 cidr block
        // then switch to default Swisscows VPN IP address
        if (/^172\.(1[6-9]|2[0-9]|3[01])\./.test(ipAddress)) {
            ipAddress = "146.185.78.169";
            country = "Switzerland";
        }

        return { ipAddress, country };
    });
}

export function getServerConfiguration(discoveryUrl = DISCOVERY_URL) {
    return fetch(discoveryUrl, {
        method: "GET",
        cache: "no-cache"
    })
    .then(response => response.json())
    // TODO: validate the response
    .catch(() => null);
}