package com.example.youtubetv;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(
                new Intent(
                        this,
                        TvHomeActivity.class
                )
        );

        finish();
    }
}
