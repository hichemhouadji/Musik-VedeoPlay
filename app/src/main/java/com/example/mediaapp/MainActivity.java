package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import static com.example.mediaapp.R.*;
import static com.example.mediaapp.R.raw.*;

public class MainActivity extends AppCompatActivity {
Button playsound;
Button playvedeo;
VideoView vedeo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        playsound=findViewById(id.playsound);
        playvedeo=findViewById(id.playvedeo);
        vedeo=findViewById(id.vedeoview);


        final MediaPlayer mp=MediaPlayer.create(this, musk);

        playsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mp.start();
            }
        });

        playvedeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController m=new MediaController(MainActivity.this);
                vedeo.setMediaController(m);

                String path="android.resource://com.example.mediaapp/"+ vedeo_r;
                Uri u= Uri.parse(path);
                vedeo.setVideoURI(u);
                vedeo.start();
            }
        });
    }
}
