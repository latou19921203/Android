package com.example.a61555.snackbardemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar snackbar = Snackbar.make(show, "This is a Snackbar", Snackbar.LENGTH_LONG);
                //添加点击"按钮"-->"确定"及其对应的点击事件
                snackbar.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "You Clicked Snackbar", Toast.LENGTH_SHORT).show();
                    }
                });
                //设置"确定"的颜色
                snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));

                //设置显示消息的文字颜色
                View snackbarView = snackbar.getView();
                ((TextView) snackbarView.findViewById(R.id.snackbar_text)).setTextColor(getResources().getColor(R.color.colorAccent));
                //设置背景颜色
                snackbarView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                //设置透明度
                snackbarView.setAlpha(0.8f);
                //显示snackbar
                snackbar.show();
            }
        });
    }
}
