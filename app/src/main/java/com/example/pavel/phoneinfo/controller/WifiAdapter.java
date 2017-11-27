package com.example.pavel.phoneinfo.controller;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.pavel.phoneinfo.data.WifiElement;

/**
 * Created by pavel on 13.11.17.
 */

/**
 * Wifi list passed like this
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

public class WifiAdapter extends ArrayAdapter<WifiElement>{

    public WifiAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull WifiElement[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Nullable
    @Override
    public WifiElement getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }



}
