package com.example.a61555.picassoframeworkdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by 61555 on 2017/8/1.
 */

public class ImageAdapter extends BaseAdapter {

    private String[] picUrls;
    private Context context;

    public ImageAdapter(String[] picUrls, Context context) {
        this.picUrls = picUrls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return picUrls.length;
    }

    @Override
    public Object getItem(int position) {
        return picUrls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);
        Picasso.with(context)
                .load(picUrls[position])
                .placeholder(R.drawable.load)
                //.resize(100, 200)
                //.centerCrop()
                .into(imageView);

        return imageView;
    }
}
