package com.example.zy.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class OrderReceiver_1 extends BroadcastReceiver {

    private final String TAG = "OrderReceiver_1";

    public OrderReceiver_1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "OrderReceiver_1被调用了");

        //取出Intent当中传递来的数据
        String msg = intent.getStringExtra("Msg");
        Log.e(TAG, "OrderReceiver_1接收到的值： " + msg);

        //向下一优先级的Receiver传递数据
        Bundle bundle = new Bundle();
        bundle.putString("Data", "（Hello）");
        setResultExtras(bundle);
    }
}
