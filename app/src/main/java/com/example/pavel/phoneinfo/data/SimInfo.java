package com.example.pavel.phoneinfo.data;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by pavel on 18.10.17.
 */

public class SimInfo {
    Context context;
    TelephonyManager telephonyManager;
    String imei1, imei2;

    public SimInfo(Context context){
        this.context = context;
        telephonyManager = (TelephonyManager)this.context.getSystemService(context.TELEPHONY_SERVICE);
    }

    public String getImei(int id){
        return telephonyManager.getDeviceId(id);
    }






}
