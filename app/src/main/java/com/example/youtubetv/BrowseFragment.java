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
                new ArrayObjectAdapter(
                        new ListRowPresenter()
                );


        ArrayObjectAdapter cardAdapter =
                new ArrayObjectAdapter(
                        new VideoCardPresenter()
                );


        for(VideoItem video :
                YouTubeSearch.search("")) {

            cardAdapter.add(video);

        }


        HeaderItem header =
                new HeaderItem(
                        0,
                        "Beranda"
                );


        rowsAdapter.add(
                new ListRow(
                        header,
                        cardAdapter
                )
        );


        setAdapter(rowsAdapter);


        setOnItemViewClickedListener(
                (itemViewHolder, item, rowViewHolder, row) -> {

                    if(item instanceof VideoItem){

                        VideoItem video =
                                (VideoItem)item;


                        android.content.Intent intent =
                                new android.content.Intent(
                                        getActivity(),
                                        PlayerActivity.class
                                );


                        intent.putExtra(
                                "video_url",
                                video.url
                        );


                        intent.putExtra(
                                "video_title",
                                video.title
                        );


                        startActivity(intent);

                    }

                }
        );
    }
}
