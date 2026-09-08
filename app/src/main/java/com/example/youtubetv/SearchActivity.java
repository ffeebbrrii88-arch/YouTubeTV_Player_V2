package com.example.youtubetv;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.Gravity;


import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRowPresenter;


import java.util.List;



public class SearchActivity extends FragmentActivity {


    ArrayObjectAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setRequestedOrientation(
                android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        );


        LinearLayout layout =
                new LinearLayout(this);

        layout.setOrientation(
                LinearLayout.VERTICAL
        );


        EditText search =
                new EditText(this);

        search.setHint(
                "Search YouTube"
        );

        search.setTextSize(24);


        layout.addView(search);


        setContentView(layout);



        search.setOnEditorActionListener(
                (v, actionId, event) -> {


                    loadSearch(
                            search.getText()
                            .toString()
                    );


                    return true;

                }
        );

    }



    private void loadSearch(
            String query
    ){

        new Thread(() -> {


            List<VideoItem> result =
                    YouTubeSearch.search(
                            query
                    );


            runOnUiThread(() -> {


                for(VideoItem item:result){

                    android.util.Log.d(
                            "YT_RESULT",
                            item.title
                    );

                }


            });


        }).start();

    }

}
