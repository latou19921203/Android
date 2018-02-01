package com.example.a61555.viewanimationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = findViewById(R.id.img);
        ImageView img2 = findViewById(R.id.img2);
        ImageView img3 = findViewById(R.id.img3);
        ImageView img4 = findViewById(R.id.img4);
        ImageView img5 = findViewById(R.id.img5);

//        直接创建 Animation
//        Animation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
//        alphaAnimation.setDuration(3000);
//        img.setAnimation(alphaAnimation);
//        alphaAnimation.start();
        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anima);
        img.setAnimation(alphaAnimation);
        alphaAnimation.start();

//        通过配置文件创建 Animation
//        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anima);
        /*
        Animation.ABSOLUTE(默认值) 相对于控件的0点的坐标值
        Animation.RELATIVE_TO_SELF 相对于自己宽或者高的百分比（1.0表示100%）
        Animation.RELATIVE_TO_PARENT 相对于父控件的宽或者高的百分比.
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        img2.setAnimation(scaleAnimation);
        scaleAnimation.start();

        /*TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 50.0f, 0.0f, 50.0f);
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(Animation.INFINITE);*/
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anima);
        img3.setAnimation(translateAnimation);
        translateAnimation.start();

        //Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anima);
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        img4.setAnimation(rotateAnimation);
        rotateAnimation.start();

        Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.set_anima);
        img5.setAnimation(setAnimation);
        setAnimation.start();
    }
}
