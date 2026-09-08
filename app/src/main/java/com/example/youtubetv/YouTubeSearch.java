package com.example.youtubetv;


import org.schabi.newpipe.extractor.ServiceList;
import org.schabi.newpipe.extractor.search.SearchExtractor;
import org.schabi.newpipe.extractor.search.SearchInfo;


import java.util.ArrayList;
import java.util.List;



public class YouTubeSearch {


    public static List<VideoItem> search(
            String text
    ){

        List<VideoItem> list =
                new ArrayList<>();


        try {


            SearchExtractor extractor =
                    ServiceList.YouTube
                    .getSearchExtractor(
                            text,
                            null,
                            null
                    );


            extractor.fetchPage();


            SearchInfo info =
                    SearchInfo.getInfo(
                            extractor
                    );


            info.getRelatedItems()
                    .forEach(item -> {


                        list.add(
                                new VideoItem(
                                        item.getName(),
                                        "",
                                        item.getThumbnailUrl()
                                )
                        );

                    });


        }catch(Exception e){

            e.printStackTrace();

        }


        return list;
    }
}
