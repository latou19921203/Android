package com.example.zy.myapplication.train;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NetworkReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkReceiver";

    public NetworkReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (NetworkUtils.getConnectState(context)) {
            case MOBILE:
                Log.e(TAG, "当前连接了移动数据");
                break;
            case WIFI:
                Log.e(TAG, "当前连接了Wifi");
                break;
            case UN_CONNECTED:
                Log.e(TAG, "当前没有网络连接");
                break;
        }
    }

}
