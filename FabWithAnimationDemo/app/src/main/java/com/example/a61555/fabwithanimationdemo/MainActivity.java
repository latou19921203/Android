package com.example.a61555.fabwithanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int FAB_SUM = 4;
    static private boolean isMainFabShow = true;
    static private boolean isSubFabGroupExpanded = false;//子浮动按钮组展开状态
    static final private int OP_FAB_ANIMA_START_DELAY = 280;//两个子浮动按钮开始动画的间隔时间

    private FloatingActionButton[] subFabs = new FloatingActionButton[FAB_SUM];
    private TextView[] subTexts = new TextView[FAB_SUM];
    private FloatingActionButton mainFab;

    private Animator mainFabInAnimator;
    private Animator mainFabOutAnimator;
    private Animator[] subFabInAnimators = new Animator[FAB_SUM];
    private Animator[] subFabOutAnimators = new Animator[FAB_SUM];
    private Animator[] subFabTextInAnimators = new Animator[FAB_SUM];
    private Animator[] subFabTextOutAnimators = new Animator[FAB_SUM];

    private Button show_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fabs);
        initFab();
        initAnimator();

        show_btn = findViewById(R.id.show_main_fab);
        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMainFabShow) {
                    if (isSubFabGroupExpanded) {
                        subFabGroupExpandToggle();//隐藏子按钮
                        mainFabOutAnimator.setStartDelay(OP_FAB_ANIMA_START_DELAY * FAB_SUM);//设置主按钮动画的Delay时间
                    } else {
                        mainFabOutAnimator.setStartDelay(0);
                    }
                    mainFabOutAnimator.start();//隐藏主按钮
                } else {
                    mainFabInAnimator.start();
                }
                isMainFabShow = !isMainFabShow;
            }
        });
    }

    private void initFab() {
        mainFab = findViewById(R.id.main_fab);
        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subFabGroupExpandToggle();
            }
        });

        subFabs[0] = findViewById(R.id.fab1);
        subFabs[1] = findViewById(R.id.fab2);
        subFabs[2] = findViewById(R.id.fab3);
        subFabs[3] = findViewById(R.id.fab4);

        subTexts[0] = findViewById(R.id.text1);
        subTexts[1] = findViewById(R.id.text2);
        subTexts[2] = findViewById(R.id.text3);
        subTexts[3] = findViewById(R.id.text4);
    }
    
    private void initAnimator() {
        if (mainFab != null) {
            mainFabInAnimator = AnimatorInflater.loadAnimator(this, R.animator.main_fab_in_animator);
            mainFabOutAnimator = AnimatorInflater.loadAnimator(this, R.animator.main_fab_out_animator);
            mainFabOutAnimator.setTarget(mainFab);
            mainFabInAnimator.setTarget(mainFab);
            mainFabInAnimator.setInterpolator(new DecelerateInterpolator());
            mainFabOutAnimator.setInterpolator(new DecelerateInterpolator());
            mainFabInAnimator.start();
        }
        for (int i=0;i<subFabs.length;i++) {
            subFabInAnimators[i] = AnimatorInflater.loadAnimator(this, R.animator.sub_fab_in_animator);
            subFabOutAnimators[i] = AnimatorInflater.loadAnimator(this, R.animator.sub_fab_out_animator);
            subFabInAnimators[i].setTarget(subFabs[i]);
            subFabOutAnimators[i].setTarget(subFabs[i]);
        }
        for (int i=0;i<subTexts.length;i++) {
            subFabTextInAnimators[i] = AnimatorInflater.loadAnimator(this, R.animator.sub_fab_in_animator);
            subFabTextOutAnimators[i] = AnimatorInflater.loadAnimator(this, R.animator.sub_fab_out_animator);
            subFabTextInAnimators[i].setTarget(subTexts[i]);
            subFabTextOutAnimators[i].setTarget(subTexts[i]);
        }
    }
    /**
     * 子浮动按钮组展开状态切换
     */
    public void subFabGroupExpandToggle() {
        if (isSubFabGroupExpanded) {
            //依次淡出效果-隐藏
            for (int i=0;i<subFabOutAnimators.length;i++) {
                subFabOutAnimators[subFabOutAnimators.length-i-1].setStartDelay(i*OP_FAB_ANIMA_START_DELAY);
                subFabTextOutAnimators[subFabOutAnimators.length-i-1].setStartDelay(i*OP_FAB_ANIMA_START_DELAY);
                subFabOutAnimators[subFabOutAnimators.length-i-1].start();
                subFabTextOutAnimators[subFabOutAnimators.length-i-1].start();
                subFabs[i].setClickable(false);//不可点击
            }
            isSubFabGroupExpanded = false;
        } else {
            //依次淡入效果-显示
            for (int i=0;i<subFabInAnimators.length;i++) {
                subFabInAnimators[i].setStartDelay(i*OP_FAB_ANIMA_START_DELAY);
                subFabTextInAnimators[i].setStartDelay(i*OP_FAB_ANIMA_START_DELAY);
                subFabInAnimators[i].start();
                subFabTextInAnimators[i].start();
                subFabs[i].setClickable(true);//可点击
            }
            isSubFabGroupExpanded = true;
        }
    }
}
