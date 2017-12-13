package com.example.a61555.maintenance_demo10.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.a61555.maintenance_demo10.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 61555 on 2017/8/15.
 */

public class FaultFragment extends HomeFragment {

    private final String DATA1_LAB = "电站名称";
    private final String DATA2_LAB = "记录日期";
    private final String DATA3_LAB = "解决进度";
    private ListView homeDataList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_list,null);
        homeDataList = (ListView) view.findViewById(R.id.home_data_list);
        homeDataList.setOnScrollListener(this);
        homeDataList.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SimpleAdapter dataListAdapter = new SimpleAdapter(getContext(), getData(), R.layout.fragment_home_item,
                new String[]{"stationIdData", "stationIdLab","setIdData", "setIdLab", "isSolved", "solvedLab"},
                new int[]{R.id.data_row1, R.id.data_row1_lab, R.id.data_row2, R.id.data_row2_lab, R.id.data_row3, R.id.data_row3_lab});
        homeDataList.setAdapter(dataListAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private List<Map<String, Object>> getData(){
        List<Map<String, Object>> dataMapList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            //添加一些测试数据
            map.put("stationIdData", "甘肃吊竹林");
            map.put("setIdData", "2017-08-15");
            map.put("isSolved", "已解决");
            map.put("stationIdLab", DATA1_LAB);
            map.put("setIdLab", DATA2_LAB);
            map.put("solvedLab", DATA3_LAB);
            dataMapList.add(map);
        }
        return dataMapList;
    }
}
