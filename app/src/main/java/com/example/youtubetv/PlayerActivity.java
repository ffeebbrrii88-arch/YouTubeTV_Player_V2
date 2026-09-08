package com.example.youtubetv;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;


public class PlayerActivity extends FragmentActivity {

    private ExoPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        PlayerView playerView =
                new PlayerView(this);

        setContentView(playerView);


        player =
                new ExoPlayer.Builder(this)
                        .build();


        playerView.setPlayer(player);


        String url =
                getIntent().getStringExtra("video_url");


        String title =
                getIntent().getStringExtra("video_title");


        if(title != null){
            Toast.makeText(
                    this,
                    title,
                    Toast.LENGTH_SHORT
            ).show();
        }


        if(url != null){

            MediaItem mediaItem =
                    MediaItem.fromUri(
                            Uri.parse(url)
                    );

            player.setMediaItem(mediaItem);

            player.prepare();

            player.play();
        }
    }


    @Override
    protected void onStop(){

        super.onStop();

        if(player != null){

            player.release();
            player=null;

        }
    }
}
