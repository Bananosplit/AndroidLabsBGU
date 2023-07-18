package com.example.tanglab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mImageView;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;
    private ImageView mImageView5;
    private ImageView mImageView6;
    private ImageView mImageView7;


    private float dX;
    private float dY;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.ImageView1);
        mImageView2 = findViewById(R.id.ImageView2);
        mImageView3 = findViewById(R.id.ImageView3);
        mImageView4 = findViewById(R.id.ImageView4);
        mImageView5 = findViewById(R.id.ImageView5);
        mImageView6 = findViewById(R.id.ImageView6);
        mImageView7 = findViewById(R.id.ImageView7);

        mImageView.setOnTouchListener(this::onTouchHandler);
        mImageView2.setOnTouchListener(this::onTouchHandler);
        mImageView3.setOnTouchListener(this::onTouchHandler);
        mImageView4.setOnTouchListener(this::onTouchHandler);
        mImageView5.setOnTouchListener(this::onTouchHandler);
        mImageView6.setOnTouchListener(this::onTouchHandler);
        mImageView7.setOnTouchListener(this::onTouchHandler);
    }


    public boolean onTouchHandler(View view, MotionEvent event) {

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getTranslationX() - event.getRawX();
                dY = view.getTranslationY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                view.setTranslationX(dX + event.getRawX());
                view.setTranslationY(dY + event.getRawY());
                break;
        }
        return true;
    }
}