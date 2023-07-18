package com.godsamix.cryptopricewidget;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t3 = findViewById(R.id.text);
        t3.setText(Html.fromHtml("Цены на NFT-монеты"));
        t3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}