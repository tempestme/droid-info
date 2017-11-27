package com.example.pavel.phoneinfo.data;

/**
 * Created by pavel on 27.11.17.
 */

public class WifiElement {
//    SSID: hostel,
//    BSSID: 04:bf:6d:06:2e:be,
//    capabilities: [WPA2-PSK-CCMP][WPS][ESS],
//    level: -87,
    String ssid;
    String bssid;
    String security;
    int level;

    public WifiElement(String ssid, String bssid, String security, int level) {
        this.ssid = ssid;
        this.bssid = bssid;
        this.security = security;
        this.level = level;
    }
}
