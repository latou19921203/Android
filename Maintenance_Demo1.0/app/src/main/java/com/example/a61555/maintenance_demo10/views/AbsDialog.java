package com.example.a61555.maintenance_demo10.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.widget.GridView;

/**
 * Created by 61555 on 2017/8/16.
 */

public abstract class AbsDialog implements GridView.OnItemClickListener {
    private AlertDialog.Builder builder;
    private Context context;
    private Dialog dialog;
    private int type;

    public AbsDialog(Context context, int type) {
        this.context = context;
        this.type = type;
        builder = new AlertDialog.Builder(context);
        initDialog();
    }

    public abstract void initDialog();

    public void setDialog(Dialog dialog){
        this.dialog = dialog;
    }
    public AlertDialog.Builder getBuilder() {
        return builder;
    }
    public Context getContext() {
        return context;
    }
    public int getType() {
        return type;
    }
    public Dialog getDialog() {
        return dialog;
    }
}
