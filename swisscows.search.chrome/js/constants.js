export const AUTHORITY_URL = "https://accounts.dev.swisscows.com";
export const CLIENT_ID = "swisscows.vpn";
export const CLIENT_CREDENTIALS = "c3dpc3Njb3dzLnZwbjpzd2lzc2Nvd3N2cG5wYXNz";

export const DISCOVERY_URL = "https://api.vpn.dev.swisscows.com/discovery.json";
export const DEFAULT_HOST = "vpn.swisscows.com";
export const DEFAULT_PORT = 8000;

export const PROXY_SERVERS = [{
    host: "vpn.swisscows.com",
    port: 8000,
    countryCode: "CH",
    country: "Switzerland"
}];

export const PROXY_BYPASS_LIST = [
    "<local>",
    "10.0.0.0/8",
    "172.16.0.0/12",
    "192.168.0.0/16",

    // production environment
    "api.swisscows.com",
    "accounts.swisscows.com",
    "vpn.swisscows.com",
    "api.vpn.swisscows.com",

    // development environment
    "api.dev.swisscows.com",
    "accounts.dev.swisscows.com",
    "vpn.dev.swisscows.com",
    "api.vpn.dev.swisscows.com"
];

export const ICON_ACTIVE = { 
    path: {
        16: "/images/icon-16-green.png",
        32: "/images/icon-32-green.png"
    }
};

export const ICON_INACTIVE = { 
    path: {
        16: "/images/icon-16-blue.png",
        32: "/images/icon-32-blue.png"
    }
};

export const ICON_ERROR = {
    path: {
        16: "/images/icon-16-red.png",
        32: "/images/icon-32-red.png"
    }
};