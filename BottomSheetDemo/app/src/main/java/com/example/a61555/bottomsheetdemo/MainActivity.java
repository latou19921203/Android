package com.example.a61555.bottomsheetdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private NestedScrollView bs1;
    private ToggleButton tb1;
    private ToggleButton tb2;
    private BottomSheetBehavior bsb1;
    private BottomSheetDialog bsd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb1 = findViewById(R.id.toggle1);
        tb2 = findViewById(R.id.toggle2);
        bs1 = findViewById(R.id.bottomsheet1);
        bsb1 = BottomSheetBehavior.from(bs1);
        bsd1 = new BottomSheetDialog(this);
        bsd1.setContentView(R.layout.bottom_sheet_dialog);

        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    bsb1.setState(BottomSheetBehavior.STATE_EXPANDED);
                else
                    bsb1.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                bsb1.setHideable(b);
            }
        });

        bsb1.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            /*
                BottomSheet状态
             */
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Toast.makeText(MainActivity.this, "BottomSheet关闭时", Toast.LENGTH_SHORT).show();
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
//                        Toast.makeText(MainActivity.this, "拖拽BottomSheet时", Toast.LENGTH_SHORT).show();
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
//                        Toast.makeText(MainActivity.this, "拖拽松开手指时", Toast.LENGTH_SHORT).show();
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Toast.makeText(MainActivity.this, "完全展开的状态", Toast.LENGTH_SHORT).show();
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Toast.makeText(MainActivity.this, "完全隐藏时的状态", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            /*
                滑动的高度
             */
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.i("[onSlide]", "slideOffset:"+slideOffset);
            }
        });
    }

    public void showBottomSheetDialog(View view) {
        bsd1.show();
    }

    public void showBottomSheetDialogFragment(View view) {
        MBottomSheetDialogFragment.getInstance().show(getSupportFragmentManager(), "MBottomSheetDialogFragment");
    }
}
