package com.example.a61555.horizontalrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HorizontalAdapter horizontalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.horizontal_recycler_view);
        horizontalAdapter = new HorizontalAdapter(getData(), MainActivity.this);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(horizontalAdapter);
    }

    public List<Data> getData() {
        List<Data> data = new ArrayList<>();
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 1"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 2"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 3"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 1"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 2"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 3"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 1"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 2"));
        data.add(new Data( R.drawable.ic_launcher_foreground, "Image 3"));
        return data;
    }
}
