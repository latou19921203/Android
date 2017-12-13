package com.example.a61555.maintenance_demo10.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.a61555.maintenance_demo10.R;
import com.example.a61555.maintenance_demo10.activity.InspectionActivity;
import com.example.a61555.maintenance_demo10.activity.ParameterActivity;
import com.example.a61555.maintenance_demo10.utils.TimePointsUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by 61555 on 2017/8/16.
 */

public class TimeListDialog extends AbsDialog {

    private SimpleAdapter timeListAdapter;
    private final int EVERY_HOUR = 1;
    private final int EVERY_FOUR_HOUR = 2;

    public TimeListDialog(Context context, int type) {
        super(context, type);
    }

    @Override
    public void initDialog() {
        AlertDialog.Builder builder = getBuilder();
        LayoutInflater factory = LayoutInflater.from(getContext());
        View timeList = factory.inflate(R.layout.layout_time_dialog_list_, null);
        initTimeList(timeList);
        builder.setIcon(null);
        builder.setMessage("点击编辑");
        builder.setView(timeList);
        builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    //
            }
        });
        switch (getType()) {
            case EVERY_HOUR:
                builder.setTitle("参数记录表"); break;
            case EVERY_FOUR_HOUR:
                builder.setTitle("巡检记录表"); break;
            default:
                break;
        }
    }

    private void initTimeList(View view) {
        GridView timeList = (GridView) view.findViewById(R.id.data_time_list);
        List<Map<String, Object>> timePointsList = null;

        switch (getType()) {
            case EVERY_HOUR:
                timePointsList = TimePointsUtils.getTimePointsList(); break;
            case EVERY_FOUR_HOUR:
                timePointsList = TimePointsUtils.getTimePointsListEach4Hour(); break;
            default:
                break;
        }
        timeListAdapter = new SimpleAdapter(getContext(), timePointsList,
                R.layout.layout_time_dialog_item, new String[]{"timePoint"}, new int[]{R.id.time_point});
        timeList.setAdapter(timeListAdapter);
        timeList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle data = new Bundle();
        data.putInt("timePoint", position);

        Intent intent = new Intent();
        switch (getType()) {
            case EVERY_HOUR:
                intent.setClass(getContext(), ParameterActivity.class); break;
            case EVERY_FOUR_HOUR:
                intent.setClass(getContext(), InspectionActivity.class); break;
        }
        intent.putExtras(data);//将需要传递的时间点信息放入intent

        getContext().startActivity(intent);//跳转页面
        getDialog().dismiss();//关闭dialog
    }
}
