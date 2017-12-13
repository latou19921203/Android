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
 * Created by 61555 on 2017/8/23.
 */

public class InspectionFormFragment extends Fragment {

    private Context context;
    private FormListView inspForm;

    public InspectionFormFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_list, container, false);
        inspForm = (FormListView) view.findViewById(R.id.form_list);
        FormAdapter adapter = new FormAdapter(getContext() ,getData(), 2);
        inspForm.setAdapter(adapter);
        inspForm.setClickable(false);
        return view;
    }

    private List<Map<String, Object>> getData() {
        String[] paraLabStrArray = getparaLabStrArray();
        List<Map<String, Object>> labMapList = new ArrayList<>();
        for (int i=0;i<paraLabStrArray.length;i++){
            Map<String, Object> map = new HashMap();
            map.put("formLab", paraLabStrArray[i]);
            labMapList.add(map);
        }
        return labMapList;
    }

    private String[] getparaLabStrArray() {
        String[] paraLabStrArray = {context.getResources().getString(R.string.insp_form_lab_text1),
                context.getResources().getString(R.string.insp_form_lab_text2), context.getResources().getString(R.string.insp_form_lab_text3),
                context.getResources().getString(R.string.insp_form_lab_text4),
                context.getResources().getString(R.string.insp_form_lab_text5), context.getResources().getString(R.string.insp_form_lab_text6),
                context.getResources().getString(R.string.insp_form_lab_text7), context.getResources().getString(R.string.insp_form_lab_text8),
                context.getResources().getString(R.string.insp_form_lab_text9), context.getResources().getString(R.string.insp_form_lab_text10),
                context.getResources().getString(R.string.insp_form_lab_text11), context.getResources().getString(R.string.insp_form_lab_text12),
                context.getResources().getString(R.string.insp_form_lab_text13), context.getResources().getString(R.string.insp_form_lab_text14),
                context.getResources().getString(R.string.insp_form_lab_text15), context.getResources().getString(R.string.insp_form_lab_text16),
                context.getResources().getString(R.string.insp_form_lab_text17), context.getResources().getString(R.string.insp_form_lab_text18)
        };
        return paraLabStrArray;
    }

    public FormListView getInspForm() {
        return inspForm;
    }
}
