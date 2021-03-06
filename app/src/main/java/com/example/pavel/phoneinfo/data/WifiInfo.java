package com.example.pavel.phoneinfo.data;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.List;

/**
 * Created by pavel on 18.10.17.
 */

public class WifiInfo {
    private WifiManager wifiManager;
    private List<ScanResult> apList;
    private Context context;
    public WifiInfo(Context context){
        this.context = context;
        wifiManager = (WifiManager)this.context.getSystemService(context.WIFI_SERVICE);
    }

    public WifiElement[] GetWifiList(){

        apList = wifiManager.getScanResults();

        String wifiList[] = new String[apList.size()];
        WifiElement wifiElement[] = new WifiElement[apList.size()];

        /**
         * This is how wifiList looks like.
         *
         *
         SSID: hostel,
         BSSID: 04:bf:6d:06:2e:be,
         capabilities: [WPA2-PSK-CCMP][WPS][ESS],
         level: -87,
         frequency: 2412,
         timestamp: 1404407568,
         distance: ?(cm),
         distanceSd: ?(cm),
         passpoint: no,
         ChannelBandwidth: 1,
         centerFreq0: 2422,
         centerFreq1: 0,
         80211mcResponder: is not supported
         */

        for (int i = 0; i < apList.size(); i++) {

//            wifiList[i] = ((apList.get(i)).toString());
//            Log.e("wifi",wifiList[i]);

            String[] item = wifiList[i].split(", ");
            String[] ssid = item[0].split(": ");
            String[] mac = item[1].split(": ");
            String[] security = item[2].split(": ");
            String[] level = item[3].split(": ");

            int intLevel = Integer.parseInt(level[0]);

            wifiElement[i] = new WifiElement(ssid[1],mac[1],security[1],intLevel);




        }
        return wifiElement;
    }

}
