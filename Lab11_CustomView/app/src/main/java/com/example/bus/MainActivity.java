package com.example.bus;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint p;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect();
        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.RED);
            p.setStrokeWidth(10);

            canvas.drawRect(30, 200, 500, 400, p);

            p.setColor(Color.BLACK);
            p.setStrokeWidth(10);

            canvas.drawCircle(100, 400, 50, p);
            canvas.drawCircle(400, 400, 50, p);

            p.setColor(Color.GRAY);
            p.setStrokeWidth(10);

            canvas.drawCircle(100, 400, 30, p);
            canvas.drawCircle(400, 400, 30, p);


            p.setColor(Color.BLUE);
            p.setStrokeWidth(10);

            canvas.drawRect(30, 250, 60, 300, p);
            canvas.drawRect(100, 250, 250, 300, p);
            canvas.drawRect(300, 250, 460, 300, p);
        }

    }

}