package com.example.lab8_zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    CheckBox chb;
    TextView tvColor, tvSize;
    Button button;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;
    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        chb = findViewById(R.id.chbExtMenu);

        tvColor = findViewById(R.id.tvColor);
        tvSize = findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);

        button = findViewById(R.id.clickBtn);


        button.setOnClickListener(view -> {

            PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
            popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(menuItem -> {
                Toast.makeText(MainActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });

            popupMenu.show();
        });
    }

    // options menu
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);

        menu.add(0, 1, 0, "Добавить");
        menu.add(0, 2, 0, "Редактировать");
        menu.add(0, 3, 3, "Удалить");
        menu.add(1, 4, 1, "Копировать");
        menu.add(1, 5, 2, "Вставить");
        menu.add(1, 6, 4, "Выход");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        StringBuilder sb = new StringBuilder();
        sb.append("Item Menu");
        sb.append("\r\n itemId: " + item.getItemId());
        sb.append("\r\n title: " + item.getTitle());
        tv.setText(sb.toString());
        return super.onOptionsItemSelected(item);
    }


    //Context Menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.tvColor:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.tvSize:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }
    }

    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                tvColor.setTextColor(Color.RED);
                return true;
            case MENU_COLOR_GREEN:
                tvColor.setTextColor(Color.GREEN);
                return true;
            case MENU_COLOR_BLUE:
                tvColor.setTextColor(Color.BLUE);
                return true;

            // пункты меню для tvSize
            case MENU_SIZE_22:
                tvSize.setTextSize(22);
                return true;
            case MENU_SIZE_26:
                tvSize.setTextSize(26);
                return true;
            case MENU_SIZE_30:
                tvSize.setTextSize(30);
                return true;
            default: return super.onContextItemSelected(item);
        }
    }

}