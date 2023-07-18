package com.example.audiomusic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    MediaPlayer elan, gan_you, kondakia, mona, raiden, shenshe;
    ImageButton elanBtn, shensheBtn, monaBtn, kondakiaBtn, raidenBtn, ganYouBtn;

    public boolean Play = false;
    public MediaPlayer CurrentPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elanBtn = (ImageButton) findViewById(R.id.imageButton);
        ganYouBtn = (ImageButton) findViewById(R.id.imageButton2);
        raidenBtn = (ImageButton) findViewById(R.id.imageButton3);
        kondakiaBtn = (ImageButton) findViewById(R.id.imageButton4);
        monaBtn = (ImageButton) findViewById(R.id.imageButton5);
        shensheBtn = (ImageButton) findViewById(R.id.imageButton6);

        elan = MediaPlayer.create(this, R.raw.elan);
        gan_you = MediaPlayer.create(this, R.raw.gan_you);
        kondakia = MediaPlayer.create(this, R.raw.kondakia);
        mona = MediaPlayer.create(this, R.raw.mona);
        raiden = MediaPlayer.create(this, R.raw.raiden);
        shenshe = MediaPlayer.create(this, R.raw.shenhe);

    }

    public void ElanPlay(View view) {
        PlayCharacterMusic(elan);
    }

    public void GanYouPlay(View view) {
        PlayCharacterMusic(gan_you);
    }

    public void RaidenPlay(View view) {
        PlayCharacterMusic(raiden);
    }

    public void KondakiaPlay(View view) {
        PlayCharacterMusic(kondakia);
    }

    public void MonaPlay(View view) {
        PlayCharacterMusic(mona);
    }

    public void ShenshePlay(View view) {
        PlayCharacterMusic(shenshe);
    }

    private void PlayCharacterMusic(MediaPlayer player) {
        if (CurrentPlayer != null && CurrentPlayer != player) {
            CurrentPlayer.pause();
            Play = false;
        }
        if (Play == false) {
            player.start();
            Play = true;
            CurrentPlayer = player;
        } else {
            player.pause();
            Play = false;
        }
    }
}