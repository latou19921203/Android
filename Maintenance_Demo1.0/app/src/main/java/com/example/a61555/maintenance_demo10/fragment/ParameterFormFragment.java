package com.example.a61555.maintenance_demo10.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a61555.maintenance_demo10.R;
import com.example.a61555.maintenance_demo10.adapter.FormAdapter;
import com.example.a61555.maintenance_demo10.views.FormListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 61555 on 2017/8/17.
 */

public class ParameterFormFragment extends Fragment {

    private Context context;
    private FormListView paraForm;
    private String[] paraLabStrArray = {"机端电压", "机端电流", "机端频率", "功率因数",
            "有功功率", "无功功率", "机组转速", "导叶开度", "推力瓦", "径向瓦", "大瓦", "前轴瓦", "后轴瓦",
            "电网电压", "电网电流", "水位"};
    private String[] unitStrArray = {"V", "A", "HZ", "cosφ", "KW",
            "Kvar", "r/min", "%", "℃", "℃", "℃", "℃", "℃", "V", "A", "M"};

    public ParameterFormFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_list, container, false);
        paraForm = (FormListView) view.findViewById(R.id.form_list);

        FormAdapter adapter = new FormAdapter(getContext(), getData() ,1);
        paraForm.setAdapter(adapter);
        paraForm.setClickable(false);
        return view;
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> labMapList = new ArrayList<>();
        for (int i=0;i<paraLabStrArray.length;i++){
            Map<String, Object> map = new HashMap();
            map.put("formLab", paraLabStrArray[i]);
            map.put("formEdit", "请输入"+paraLabStrArray[i]+"("+unitStrArray[i]+")");
            labMapList.add(map);
        }
        return labMapList;
    }

    public FormListView getParaForm() {
        return paraForm;
    }
}
