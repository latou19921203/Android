package com.example.a61555.animatordemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private Spinner spinner;
    private String[] strs = {"Accelerate", "Anticipate", "Linear", "Decelerate", "Bounce",
            "Overshoot", "Accelerate-Decelerate", "Anticipate-Overshoot", "LinearOut-SlowIn",
            "FastOut-LinearIn"};
    private int selectedItemNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            属性动画
            ObjectAnimator
         */
        imageView = findViewById(R.id.img1);
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator1);
        animator.setTarget(imageView);//绑定View
        animator.start();//开始动画

        ImageView imageView2 = findViewById(R.id.img2);
        Animator animator2 = AnimatorInflater.loadAnimator(this, R.animator.animator2);
        animator2.setTarget(imageView2);//绑定View
        animator2.start();

        ImageView imageView3 = findViewById(R.id.img3);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView3, "translationX", 0F, 500F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(imageView3, "translationY", 0F, 500F);
        animatorSet.playTogether(animator3, animator4);//同时播放
        animatorSet.setDuration(5000).start();

        ImageView imageView4 = findViewById(R.id.img4);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(imageView4, "translationX", 0F, 300F);
        ObjectAnimator animator6 = ObjectAnimator.ofFloat(imageView4, "translationY", 0F, 300F);
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(animator5, animator6);//按排列顺序播放
        set.setDuration(3000).start();

        ImageView imageView5 = findViewById(R.id.img5);
        ObjectAnimator animator7 = ObjectAnimator.ofFloat(imageView5, "translationX", 0F, 200F);
        ObjectAnimator animator8 = ObjectAnimator.ofFloat(imageView5, "translationY", 0F, 200F);
        ObjectAnimator animator9 = ObjectAnimator.ofFloat(imageView5, "rotation", 0F, 360F);
        AnimatorSet set2 = new AnimatorSet();
        set2.play(animator7).with(animator8);//同时
        set2.play(animator9).after(animator7);//之后, 另外还有before之前
        set2.setDuration(1000).start();
        //Animator回调方法
        animator9.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });

        spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strs);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItemNum = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        /*
            属性动画
            ValueAnimator
         */
        textView = findViewById(R.id.value1);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer value = (Integer) valueAnimator.getAnimatedValue();
                textView.setText(""+value);
            }
        });
        valueAnimator.start();
    }
    //设置动画曲线
    public void playAnimator (View view) {

        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator1);
        animator.setTarget(imageView);

        switch (selectedItemNum) {
            case 0:
                animator.setInterpolator(new AccelerateInterpolator());
                break;
            case 1:
                animator.setInterpolator(new AnticipateInterpolator());
                break;
            case 2:
                animator.setInterpolator(new LinearInterpolator());
                break;
            case 3:
                animator.setInterpolator(new DecelerateInterpolator());
                break;
            case 4:
                animator.setInterpolator(new BounceInterpolator());
                break;
            case 5:
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case 6:
                animator.setInterpolator(new AnticipateOvershootInterpolator());
                break;
            case 7:
                animator.setInterpolator(new LinearOutSlowInInterpolator());
                break;
            case 8:
                animator.setInterpolator(new FastOutLinearInInterpolator());
                break;
        }
        animator.start();//开始动画
    }
}
