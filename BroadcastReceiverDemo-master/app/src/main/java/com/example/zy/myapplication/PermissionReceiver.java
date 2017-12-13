package com.example.zy.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PermissionReceiver extends BroadcastReceiver {

    private final String TAG = "PermissionReceiver";

    public PermissionReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "接收到了私有权限广播");
    }
}
