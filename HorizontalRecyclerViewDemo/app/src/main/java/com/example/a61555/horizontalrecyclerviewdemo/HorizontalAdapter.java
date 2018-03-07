package com.example.a61555.horizontalrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 61555 on 2018/3/7.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {


    List<Data> horizontalList;
    Context context;


    public HorizontalAdapter(List<Data> horizontalList, Context context) {
        this.horizontalList = horizontalList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

//        holder.imageView.setImageResource(horizontalList.get(position).imageId);
        holder.textView.setText(horizontalList.get(position).txt);

//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String list = horizontalList.get(position).txt.toString();
//                Toast.makeText(context, list, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount()
    {
        return horizontalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.item_img);
            textView = view.findViewById(R.id.item_text);
        }
    }
}