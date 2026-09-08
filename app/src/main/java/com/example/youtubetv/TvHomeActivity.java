package com.example.youtubetv;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class TvHomeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new BrowseFragment())
                    .commit();
        }
    }
}
