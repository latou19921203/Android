package com.example.a61555.pickpicturedemo.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a61555.pickpicturedemo.R;

import java.util.List;

/**
 * 照片浏览
 * Created by 61555 on 2017/12/13.
 */

public class PickPictureAdapter extends CygAdapter<String> {

    public PickPictureAdapter(Context context, List<String> datas) {
        super(context, R.layout.activity_pick_picture_grid_item, datas);
    }

    @Override
    public void onBindData(CygViewHolder viewHolder, String item, int position) {
        ImageView imageView = viewHolder.findViewById(R.id.activity_pick_picture_grid_item_image);
        try {
            Glide.with(mContext).load(item).into(imageView);
        } catch(IllegalArgumentException ex) {
            Log.wtf("Glide-tag", String.valueOf(imageView.getTag()));
        }
    }
}
