package com.example.youtubetv;

import com.example.youtubetv.ExtractorInit;



import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ExtractorInit.init();

        super.onCreate(savedInstanceState);

        setRequestedOrientation(
                android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        );

        startActivity(
                new Intent(
                        this,
                        TvHomeActivity.class
                )
        );

        finish();
    }
}
