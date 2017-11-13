package com.example.pavel.phoneinfo.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pavel on 28.10.17.
 */

public class PermissionHandler extends Activity{
    String[] permissions;
    Context context;
    {
        final int PERMISSION_REQUEST_CODE = 123;

    }
    PermissionHandler(Context context){
        this.context = context;
    }
    PermissionHandler(String[] permissions, Context context){
        this.permissions = permissions;
        this.context = context;
    }










}
