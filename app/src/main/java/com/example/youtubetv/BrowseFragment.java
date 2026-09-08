package com.example.youtubetv;

import android.os.Bundle;

import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

public class BrowseFragment extends BrowseSupportFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setTitle("YouTube TV Player V2");

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        loadRows();
    }


    private void loadRows() {

        ArrayObjectAdapter rowsAdapter =
                new ArrayObjectAdapter(new ListRowPresenter());


        ArrayObjectAdapter cardAdapter =
                new ArrayObjectAdapter(
                        new VideoCardPresenter()
                );


        cardAdapter.add("Video Pertama");
        cardAdapter.add("Video Kedua");
        cardAdapter.add("Video Ketiga");
        cardAdapter.add("Video Keempat");


        HeaderItem header =
                new HeaderItem(0, "Beranda");


        rowsAdapter.add(
                new ListRow(header, cardAdapter)
        );


        setAdapter(rowsAdapter);
    }
}
