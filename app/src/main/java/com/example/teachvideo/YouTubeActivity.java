package com.example.teachvideo;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class YouTubeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView playerview;
    private YouTubePlayer youtubeplayer;
    private TextView NameVideo;
    String video;
    Mask mask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        configurationNextButton();
        mask=getIntent().getParcelableExtra("video");
        NameVideo =  (TextView) findViewById(R.id.Name);
        playerview = (YouTubePlayerView) findViewById(R.id.player);
        video=mask.getVideo();
        NameVideo.setText(mask.getName());
        playerview.initialize("AIzaSyCyfLCpjzz4mhjwN3zGXih6kCyRM9cAeOw", this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private void configurationNextButton()
    {
        Button addData = (Button) findViewById(R.id.back);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YouTubeActivity.this, glavnaya.class));
            }
        });
    }
    @Override
    public void onInitializationFailure(Provider arg0,
                                        YouTubeInitializationResult arg1) {
        Toast.makeText(this, "???????????? ?????? ???????????????? ??????????", Toast.LENGTH_LONG)
                .show();
    }

    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        youtubeplayer = player;
        if (!wasRestored) {
            Toast.makeText(this, "?????????? ?????????????? ??????????????????",
                    Toast.LENGTH_LONG).show();
            player.cueVideo(video);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.player);
    }

}