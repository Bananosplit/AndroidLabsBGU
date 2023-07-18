package com.example.myapplication03;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String dataStr = "";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = new TextView(this);
        textView.setText("Нажми и перетащи, используя один палец");
        textView.setOnTouchListener((view, event) ->{
            dataStr = "";
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dataStr = dataStr + "down, ";
                    break;
                case MotionEvent.ACTION_MOVE:
                    dataStr = dataStr + "move, ";
                    break;
                case MotionEvent.ACTION_CANCEL:
                    dataStr = dataStr + "cancel, ";
                    break;
                case MotionEvent.ACTION_UP:
                    dataStr = dataStr + "up, ";
                    break;
            }
            dataStr = dataStr + event.getX() + ", " + event.getY();
            textView.setText(dataStr);
            return true;
        });
        setContentView(textView);
    }
}