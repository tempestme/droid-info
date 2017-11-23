package com.example.pavel.phoneinfo.view;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavel.phoneinfo.R;
import com.example.pavel.phoneinfo.data.SimInfo;
import com.example.pavel.phoneinfo.data.WifiInfo;

import at.grabner.circleprogress.CircleProgressView;

public class MainActivity extends AppCompatActivity {
    TelephonyManager telephonyManager;
    RecyclerView cellList, wifiList;
    ProgressBar storeProgress, sdCardProgress, memoryProgress, unknownprogress; //TODO: Определиться по третей графе прогресса
    CircleProgressView progress;
    TextView imei1, imei2;

    SimInfo simInfo;
    WifiInfo wifInfo;

    private final int WIFI_STATE_CODE = 100;
    private final int PHONE_STATE_REQUEST_CODE = 101;
    private final int ACCESS_FINE_LOCATION_CODE = 102;

    /**
     * for circle progress view used https://github.com/jakob-grabner/Circle-Progress-View
     * for permission handle used https://github.com/tbruyelle/RxPermissions
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askPermissions(Manifest.permission.READ_PHONE_STATE, PHONE_STATE_REQUEST_CODE);
        askPermissions(Manifest.permission.ACCESS_WIFI_STATE, WIFI_STATE_CODE);
        askPermissions(Manifest.permission.ACCESS_FINE_LOCATION, ACCESS_FINE_LOCATION_CODE);

        imei1 = (TextView)findViewById(R.id.imei1TextView);
        imei2 = (TextView)findViewById(R.id.imei2TextView);

        simInfo = new SimInfo(getApplicationContext());
        wifInfo = new WifiInfo(getApplicationContext());
        String[] Wifi1 = wifInfo.GetWifiList();

        /**
         * all permissions and object is in, gogo
         */

        imei1.setText(simInfo.getImei(0));
        imei2.setText(simInfo.getImei(1));




//
//        Log.e("loh",imei1);

    }

    private void askPermissions(String permissions, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permissions) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permissions}, requestCode);
        }
        else {
            Log.e("permission","already have permission "+Integer.toString(requestCode));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PHONE_STATE_REQUEST_CODE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Log.e("permission", "Permission PHONE_STATE_REQUEST granted" );
                }
                else{
                    Log.e("permission", "Permission PHONE_STATE_REQUEST denied" );
                }

            case ACCESS_FINE_LOCATION_CODE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Log.e("permission", "ACCESS_FINE_LOCATION_CODE granted" );
                }
                else{
                    Log.e("permission", "ACCESS_FINE_LOCATION_CODE denied" );
                }

            case WIFI_STATE_CODE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Log.e("permission", "Permission WIFI_STATE_CODE granted" );
                }
                else{
                    Log.e("permission", "Permission WIFI_STATE_CODE denied" );
                }

        }





        }
    }


