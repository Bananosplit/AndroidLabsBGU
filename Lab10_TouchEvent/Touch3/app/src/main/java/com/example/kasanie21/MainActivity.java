package com.example.kasanie21;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private ImageView mImageView;
    private ViewGroup mMoveLayout;
    private float dX;
    private float dY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMoveLayout = findViewById(R.id.move);
        mImageView = mMoveLayout.findViewById(R.id.ImageView);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(256, 256);
        mImageView.setLayoutParams(layoutParams);
        mImageView.setOnTouchListener((view, event) -> {

            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:

                    dX = view.getTranslationX() - event.getRawX();
                    dY = view.getTranslationY() - event.getRawY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    if(event.getRawX() > view.getWidth() && event.getRawX() < getDisplay().getWidth() - (view.getWidth() / 2)){
                        view.setTranslationX(event.getRawX() + dX);
                        view.setTranslationY(event.getRawY() + dY);
                        break;}

                default: return true;
            }
            return true;
        });
    }

}