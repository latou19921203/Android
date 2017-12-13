package com.example.zy.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class OrderReceiver_2 extends BroadcastReceiver {

    private final String TAG = "OrderReceiver_2";

    public OrderReceiver_2() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "OrderReceiver_2被调用了");

        //取出上一优先级的Receiver传递来的数据
        String data = getResultExtras(true).getString("Data");
        Log.e(TAG, "从上一优先级的Receiver传递来的数据--" + data);

        //向下一优先级的Receiver传递数据
        Bundle bundle = new Bundle();
        bundle.putString("Data", "（叶应是叶）");
        setResultExtras(bundle);

        //abortBroadcast();
    }
}
