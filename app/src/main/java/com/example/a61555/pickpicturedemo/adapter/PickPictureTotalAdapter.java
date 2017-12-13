package com.example.a61555.pickpicturedemo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a61555.pickpicturedemo.R;
import com.example.a61555.pickpicturedemo.tool.PictureTotal;

import java.util.List;

/**
 * Created by 61555 on 2017/12/13.
 */

public class PickPictureTotalAdapter extends CygAdapter<PictureTotal> {
    public PickPictureTotalAdapter(Context context, List<PictureTotal> objects) {
        super(context, R.layout.activity_pick_picture_total_list_item, objects);
    }

    @Override
    public void onBindData(CygViewHolder viewHolder, PictureTotal item, int position) {
        viewHolder.setText(R.id.pick_picture_total_list_item_group_title, item.getFolderName());
        viewHolder.setText(R.id.pick_picture_total_list_item_group_count
                , "(" + Integer.toString(item.getPictureCount()) + ")");
        ImageView imageView = viewHolder.findViewById(R.id.pick_picture_total_list_item_group_image);
        Glide.with(mContext).load(item.getTopPicturePath()).into(imageView);
    }
}
