package com.example.appcolorrebuild;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    Button Button1;

    EditText EditText1;
    EditText EditText2;
    EditText EditText3;

    SwitchCompat SwitchToggleBtn;
    AppCompatCheckBox UseFloatRGB;
    AppCompatCheckBox UseSimpleColor;


    int newBtnColor;

    private boolean CanSwitchColor = true;
    private boolean isUseFloatRGB = false;
    private boolean isUseSimpleColor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1 = (Button) findViewById(R.id.Button1);

        EditText1 = (EditText) findViewById(R.id.editText1);
        EditText2 = (EditText) findViewById(R.id.EditText2);
        EditText3 = (EditText) findViewById(R.id.EditText3);

        SwitchToggleBtn = findViewById(R.id.SwitchColor);
        UseFloatRGB = findViewById(R.id.UseFloatRgb);
        UseSimpleColor = findViewById(R.id.UseSimpleRgb);

        SwitchToggleBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked == true){
                SetColorBtn(Color.BLACK);
                CanSwitchColor = false;
                Button1.setText(R.string.Submit);
            } else {
                CanSwitchColor = true;
                Button1.setText(R.string.Submit);
            }
        });
        UseFloatRGB.setOnClickListener(v -> {
            if(UseFloatRGB.isChecked())
                isUseFloatRGB = true;
            else isUseFloatRGB = false;
        });
        UseSimpleColor.setOnClickListener(v -> {
            if(UseSimpleColor.isChecked())
                isUseSimpleColor = true;
            else isUseSimpleColor = false;
        });
        Button1.setOnClickListener(v -> {

            if(isUseFloatRGB && CanSwitchColor){

                String r = EditText1.getText().toString();
                String g = EditText2.getText().toString();
                String b = EditText3.getText().toString();

                int int_r = !r.isEmpty() ? Integer.parseInt(r): 0;
                int int_g = !g.isEmpty() ? Integer.parseInt(g): 0;
                int int_b = !b.isEmpty() ? Integer.parseInt(b): 0;

                newBtnColor = Color.rgb(int_r, int_g, int_b);
                SetColorBtn(newBtnColor);
                Button1.setText("Color Changed");
            } else if (isUseSimpleColor && CanSwitchColor){
                RadioGroup group = findViewById(R.id.ColorGroup);
                int checkedItem = group.getCheckedRadioButtonId();
                switch (checkedItem){
                    case R.id.Image1:
                        SetColorBtn(Color.RED);
                        break;
                    case R.id.Image2:
                        SetColorBtn(Color.GREEN);
                        break;
                    case R.id.Image3:
                        SetColorBtn(Color.BLUE);
                        break;
                }
            }
            else
                Toast.makeText(this, "Enter Type color set", Toast.LENGTH_LONG);
         });
    }

    private void SetColorBtn(int color){
        Button1.setBackgroundColor(color);
    }

}