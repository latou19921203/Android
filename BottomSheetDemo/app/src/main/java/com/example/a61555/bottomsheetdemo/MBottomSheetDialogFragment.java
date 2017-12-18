package com.example.a61555.bottomsheetdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 61555 on 2017/12/18.
 */

public class MBottomSheetDialogFragment extends BottomSheetDialogFragment {

    public static MBottomSheetDialogFragment getInstance() {
        return new MBottomSheetDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_dialog, container, false);
    }
}
