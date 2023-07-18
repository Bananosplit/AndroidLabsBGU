package com.example.animationlab;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

public class MainActivity extends AppCompatActivity {

    //Frame animation
    AnimationDrawable anim;
    AppCompatEditText input;
    AppCompatButton setSpeedBtn;
    int duration = 0;
    //Object animator

    TextView alpha;
    TextView rotation;
    TextView scale;

    AppCompatButton alphaBtn;
    AppCompatButton rotateBtn;
    AppCompatButton scaleBtn;

    ObjectAnimator Animator;

    boolean alphaSwitch = true;
    boolean rotateSwitch = true;
    boolean scaleSwitch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // anim = (AnimationDrawable)img.getBackground();
        //Logic Frame animation

            input = findViewById(R.id.SetSpeedForFrames);
            setSpeedBtn = findViewById(R.id.SetSpeedBtn);
            setSpeedBtn.setOnClickListener(v -> {
                duration = Integer.parseInt(input.getText().toString());

                anim = new AnimationDrawable();
                anim.setOneShot(false);

                anim.addFrame(getResources().getDrawable(R.drawable.pict1), duration);
                anim.addFrame(getResources().getDrawable(R.drawable.pict2), duration);
                anim.addFrame(getResources().getDrawable(R.drawable.pict3), duration);
                anim.addFrame(getResources().getDrawable(R.drawable.pict4), duration);


                ImageView img = findViewById(R.id.myAnimation);
                img.setBackground(anim);
                anim.start();
            });



        // Logic Object Animation
        alpha = findViewById(R.id.anim_text_alpha);
        rotation = findViewById(R.id.anim_text_rotate);
        scale = findViewById(R.id.anim_text_scale);

        alphaBtn = findViewById(R.id.alpha_btn);
        rotateBtn = findViewById(R.id.rotate_btn);
        scaleBtn = findViewById(R.id.scale_btn);

        alphaBtn.setOnClickListener(v -> {

            if(alphaSwitch){
                Animator = ObjectAnimator.ofFloat(alpha, "alpha", 0);
                Animator.setDuration(2000);
                Animator.start();
            } else {
                Animator = ObjectAnimator.ofFloat(alpha, "alpha", 1);
                Animator.setDuration(2000);
                Animator.start();
            }
            alphaSwitch = !alphaSwitch;
        });

        rotateBtn.setOnClickListener(v -> {
            if(rotateSwitch){
                Animator = ObjectAnimator.ofFloat(rotation, "rotation", 360);
                Animator.setDuration(2000);
                Animator.start();
            } else {

                Animator = ObjectAnimator.ofFloat(rotation, "rotation", 0);
                Animator.setDuration(2000);
                Animator.start();
            }
            rotateSwitch = !rotateSwitch;
        });

        scaleBtn.setOnClickListener(v -> {
            if(scaleSwitch){
                Animator = ObjectAnimator.ofFloat(scale, "scaleX", 3);
                Animator = ObjectAnimator.ofFloat(scale, "scaleY", 3);
                Animator.setDuration(1000);
                Animator.start();
            } else {
                Animator = ObjectAnimator.ofFloat(scale, "scaleX", 1);
                Animator = ObjectAnimator.ofFloat(scale, "scaleY", 1);
                Animator.setDuration(1000);
                Animator.start();
            }
            scaleSwitch = !scaleSwitch;
        });
    }
/*
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        anim.start();
    }*/
}