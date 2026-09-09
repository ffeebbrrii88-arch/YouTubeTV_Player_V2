package com.example.youtubetv;

import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.InfoItem;
import org.schabi.newpipe.extractor.search.SearchInfo;
import org.schabi.newpipe.extractor.linkhandler.SearchQueryHandler;
import org.schabi.newpipe.extractor.stream.StreamInfoItem;

import java.util.ArrayList;
import java.util.List;

public class YouTubeSearch {

    public static List<VideoItem> search(String query) {

        List<VideoItem> list = new ArrayList<>();

        try {

            SearchQueryHandler handler =
                    ServiceList.YouTube
                            .getSearchQHFactory()
                            .fromQuery(query);


            SearchInfo info =
                    SearchInfo.getInfo(
                            ServiceList.YouTube,
                            handler
                    );


            for(InfoItem item : info.getRelatedItems()) {

                if(item instanceof StreamInfoItem) {

                    StreamInfoItem video =
                            (StreamInfoItem)item;


                    String thumbnail = "";

                    if(video.getThumbnails() != null &&
                            !video.getThumbnails().isEmpty()) {

                        thumbnail =
                                video.getThumbnails()
                                        .get(0)
                                        .getUrl();
                    }


                    list.add(
                            new VideoItem(
                                    video.getName(),
                                    video.getUrl(),
                                    thumbnail
                            )
                    );
                }
            }


        } catch(Exception e) {

            e.printStackTrace();

        }


        return list;
    }
}
