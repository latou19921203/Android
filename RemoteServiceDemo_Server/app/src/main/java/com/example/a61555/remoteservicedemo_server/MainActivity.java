package com.example.a61555.remoteservicedemo_server;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 远程通信服务 Server端
 * 需要定义aidl文件，并在Service中实现接口
 * 在配置文件中打开远程服务，action的name与Client端中Intent
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
