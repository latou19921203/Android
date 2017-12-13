package com.example.a61555.maintenance_demo10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a61555.maintenance_demo10.R;

import java.util.List;
import java.util.Map;

/**
 * Created by 61555 on 2017/8/17.
 */

public class FormAdapter extends BaseAdapter {

    private List<Map<String, Object>> data;
    private LayoutInflater inflater;
    private Context context;
    private int formType;
    private final int PARAMETER_FORM = 1;
    private final int INSPECTION_FORM = 2;

    public FormAdapter(Context context, List<Map<String, Object>> data, int formType) {
        this.context = context;
        this.data = data;
        this.formType = formType;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View form = null;
        TextView formLab;
        Map formMap = data.get(position);

        switch (formType) {
            case PARAMETER_FORM:
                //使用ConvertView来重用View
                if (convertView == null) {
                    form = inflater.inflate(R.layout.fragment_form_item_para, parent, false);
                } else {
                    form = convertView;
                }
                formLab = (TextView) form.findViewById(R.id.form_lab);
                EditText formEdit = (EditText) form.findViewById(R.id.form_edit);
                formLab.setText(formMap.get("formLab").toString());
                formEdit.setHint(formMap.get("formEdit").toString());//设置EditText提示信息
                break;

            case INSPECTION_FORM:
                //使用ConvertView来重用View
                if (convertView == null) {
                    form = inflater.inflate(R.layout.fragment_form_item_insp, parent, false);
                } else {
                    form = convertView;
                }
                formLab = (TextView) form.findViewById(R.id.form_lab);
                formLab.setText(formMap.get("formLab").toString());
                break;

            default: break;
        }
        return form;
    }
}
