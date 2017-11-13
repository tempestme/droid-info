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
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.example.pavel.phoneinfo.R;

import at.grabner.circleprogress.CircleProgressView;

public class MainActivity extends AppCompatActivity {
    TelephonyManager telephonyManager;
    RecyclerView cellList;
    RecyclerView wifiList;
    ProgressBar storeProgress, sdCardProgress, memoryProgress, unknownprogress; //TODO: Определиться по третей графе прогресса
    CircleProgressView progress;
    String imei1;
    String imei2;

    Button Permission_btn;

    private final int PHONE_STATE_REQUEST_CODE = 101;

    /**
     * for circle progress view used https://github.com/jakob-grabner/Circle-Progress-View
     * for permission handle used https://github.com/tbruyelle/RxPermissions
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Permission_btn = (Button)findViewById(R.id.permissionBTN);

        Permission_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermissions(Manifest.permission.READ_PHONE_STATE, PHONE_STATE_REQUEST_CODE);
            }
        });



        telephonyManager = (TelephonyManager)getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
        imei1 = telephonyManager.getDeviceId(0);
        imei2 = telephonyManager.getDeviceId(1);
        Log.e("imei", imei1);
        Log.e("imei", imei2);

//
//        Log.e("loh",imei1);

    }

    private void askPermissions(String permissions, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permissions) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permissions}, requestCode);
        }
        else {
            Toast.makeText(getApplicationContext(),"already have permission",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PHONE_STATE_REQUEST_CODE:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(),"permission granted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"permission denied",Toast.LENGTH_SHORT).show();
                }
            }



        }
    }


