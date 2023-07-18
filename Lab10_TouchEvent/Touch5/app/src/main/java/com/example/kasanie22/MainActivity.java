package com.example.kasanie22;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView StartGameLabel;
    Button StartGameBtn;
    int counter = 0;
    int scoreData =0;

    ImageView target1, target2, target3, target4, target5, target6, target7;
    List<ImageView> TargetImages = new ArrayList<>();

    MediaPlayer PlayerWin;
    MediaPlayer PlayerLoose;

    enum GameState {
      Start, Loop, End, Reset
    }

    GameState currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentState = GameState.Start;

        FindImageAndInitialize();

        PlayerWin = MediaPlayer.create(this, R.raw.audio1);
        PlayerLoose = MediaPlayer.create(this, R.raw.fail1);

        StartGameLabel = findViewById(R.id.StartGameLabel);

        StartGameBtn = findViewById(R.id.StartBtn);
    }



    public void onClickStartBtn(View view)
    {
        StartGameLabel.setVisibility(View.INVISIBLE);
        StartGameBtn.setVisibility(View.INVISIBLE);

        double x = (Math.random() * ((265 - 0) + 1)) + 0;
        double y = (Math.random() * ((733 - 0) + 1)) + 0;

        if(currentState == GameState.Start){
            SpawnRandomImage(TargetImages.get(0),(float) x,(float) y);
            currentState = GameState.Loop;
        }
        else if (currentState == GameState.End) {
            StartGameLabel.setVisibility(View.VISIBLE);
            StartGameLabel.setText("Ваш счет " + scoreData);
            currentState = GameState.Reset;
        }
    }

    public void onClickOnIcon(View view)
    {
        if(currentState == GameState.Loop){
            scoreData++;
            TargetImages.get(counter - 1).setVisibility(View.INVISIBLE);
            ImageClickHandler(TargetImages.get(counter));
            PlayerWin.start();
        }
        else if (currentState == GameState.End){
            TargetImages.get(counter - 1).setVisibility(View.INVISIBLE);
            StartGameBtn.setVisibility(View.VISIBLE);
            StartGameBtn.setText("Завершить");
        }
    }

    public void onImageMissing(View view)
    {
        if(currentState == GameState.Loop) {
            scoreData--;
            TargetImages.get(counter - 1).setVisibility(View.INVISIBLE);
            ImageClickHandler(TargetImages.get(counter));
            PlayerLoose.start();
        }
        else if (currentState == GameState.End){
            TargetImages.get(counter - 1).setVisibility(View.INVISIBLE);
            StartGameBtn.setVisibility(View.VISIBLE);
            StartGameBtn.setText("Завершить");
        }
        else if (currentState == GameState.Reset){
            StartGameBtn.setVisibility(View.VISIBLE);
            StartGameBtn.setText("Начать заново");
            counter = 0;
            scoreData = 0;
            currentState = GameState.Start;
        }
    }

    private void ImageClickHandler(ImageView target ) {
        target.setVisibility(View.GONE);

        double x = (Math.random() * ((265 - 0) + 1)) + 0;
        double y = (Math.random() * ((733 - 0) + 1)) + 0;

        SpawnRandomImage(target,(float) x,(float) y);
    }

    private void SpawnRandomImage(ImageView target ,float x, float y) {
        target.setX(x);
        target.setY(y);
        target.setVisibility(View.VISIBLE);
        counter++;
        if(counter > 6)
            currentState = GameState.End;
    }

    private void FindImageAndInitialize() {

        target1 = findViewById(R.id.imageView3);
        target1.setVisibility(View.INVISIBLE);
        TargetImages.add(target1);

        target2 = findViewById(R.id.imageView6);
        target2.setVisibility(View.INVISIBLE);
        TargetImages.add(target2);

        target3 = findViewById(R.id.imageView4);
        target3.setVisibility(View.INVISIBLE);
        TargetImages.add(target3);

        target4 = findViewById(R.id.imageView2);
        target4.setVisibility(View.INVISIBLE);
        TargetImages.add(target4);

        target5 = findViewById(R.id.imageView5);
        target5.setVisibility(View.INVISIBLE);
        TargetImages.add(target5);

        target6 = findViewById(R.id.imageView);
        target6.setVisibility(View.INVISIBLE);
        TargetImages.add(target6);

        target7 = findViewById(R.id.imageView7);
        target7.setVisibility(View.INVISIBLE);
        TargetImages.add(target7);
    }
}
