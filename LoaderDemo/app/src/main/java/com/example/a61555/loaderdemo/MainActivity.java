package com.example.a61555.loaderdemo;

import android.app.LoaderManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LoaderManager loaderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.app.FragmentManager manager = getFragmentManager();
        manager.beginTransaction().add(R.id.container, new CursorLoaderListFragment()).commit();
    }
}
