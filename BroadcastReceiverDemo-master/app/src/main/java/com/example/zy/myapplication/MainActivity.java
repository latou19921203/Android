package com.example.zy.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final String NORMAL_ACTION = "com.example.normal.receiver";
    private final String ORDER_ACTION = "com.example.order.receiver";
    public final static String ACTION = "com.example.receiver";
    private final String TAG = "MainActivity";
    private BroadcastReceiver batteryReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    private final String LOCAL_ACTION = "com.example.local.receiver";
    private final String PERMISSION_PRIVATE = "com.example.permission.receiver";
    private PermissionReceiver permissionReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        batteryReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // 当前电量
                int currentBattery = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                // 总电量
                int totalBattery = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                Log.e(TAG, "当前电量:" + currentBattery + "-总电量：" + totalBattery);
            }
        };
        registerReceiver(batteryReceiver, intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localReceiver = new LocalReceiver();
        IntentFilter filter = new IntentFilter(LOCAL_ACTION);
        localBroadcastManager.registerReceiver(localReceiver, filter);//注册本地广播

        IntentFilter intentFilter1 = new IntentFilter("Hi");
        permissionReceiver = new PermissionReceiver();
        registerReceiver(permissionReceiver, intentFilter1, PERMISSION_PRIVATE, null);//权限广播
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
        unregisterReceiver(permissionReceiver);
    }

    public void sendNormalBroadcast(View view) {
        Intent intent = new Intent(NORMAL_ACTION);
        intent.putExtra("Msg", "Hi");
        sendBroadcast(intent);
    }

    public void sendOrderBroadcast(View view) {
        Intent intent = new Intent(ORDER_ACTION);
        intent.putExtra("Msg", "Hi");
        sendOrderedBroadcast(intent, null);
    }

    public void sendLocalBroadcast(View view) {
        Intent intent = new Intent(LOCAL_ACTION);
        localBroadcastManager.sendBroadcast(intent);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, BroadcastService.class);
        startService(intent);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent(ACTION);
        sendBroadcast(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, BroadcastService.class);
        stopService(intent);
    }

}
