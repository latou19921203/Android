package com.example.a61555.vectordrawableanimatordemo;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
    }

    public void selected(View view) {
        button.setSelected(!(button.isSelected()));
    }

    public void play(View view) {
        ImageButton ib = (ImageButton) view;
        Drawable drawable = ib.getDrawable();
        if (drawable instanceof Animatable) {
            if (!((Animatable) drawable).isRunning())
                ((Animatable) drawable).start();
            else
                ((Animatable) drawable).stop();
        }
    }
}
