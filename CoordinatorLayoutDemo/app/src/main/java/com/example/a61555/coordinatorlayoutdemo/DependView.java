package com.example.a61555.coordinatorlayoutdemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

/**
 * Created by 61555 on 2017/12/15.
 * 自定义View
 */

public class DependView extends AppCompatTextView{

    private int lastX;
    private int lastY;
    private int mWidth;
    private int mHeight;
    private int screenWidth;
    private int screenHeight;

    public DependView(Context context) {
        super(context);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        screenWidth = display.widthPixels;
        screenHeight = display.heightPixels;
    }

    public DependView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    /*
        对当前View的尺寸进行测量
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
                int left = layoutParams.leftMargin + x - lastX;
                int top = layoutParams.topMargin + y - lastY;

                layoutParams.leftMargin = left;
                layoutParams.topMargin = top;
                setLayoutParams(layoutParams);
                requestLayout();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        lastX = x;
        lastY = y;
        return true;
    }
}
