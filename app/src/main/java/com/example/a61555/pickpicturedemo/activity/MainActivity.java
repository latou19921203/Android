package com.example.a61555.pickpicturedemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a61555.pickpicturedemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPictureTotal(View view) {
        PickPictureTotalActivity.gotoActivity(MainActivity.this);
    }
}
