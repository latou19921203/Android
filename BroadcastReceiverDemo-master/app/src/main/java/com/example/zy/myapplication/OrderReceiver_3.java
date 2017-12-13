package com.example.zy.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OrderReceiver_3 extends BroadcastReceiver {

    private final String TAG = "OrderReceiver_3";

    public OrderReceiver_3() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "OrderReceiver_3被调用了");

        //取出上一优先级的Receiver传递来的数据
        String data = getResultExtras(true).getString("Data");
        Log.e(TAG, "从上一优先级的Receiver传递来的数据--" + data);
    }
}
