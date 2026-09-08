package com.example.youtubetv;

import java.util.ArrayList;
import java.util.List;

public class YouTubeSearch {

    public static List<VideoItem> search(String query) {

        List<VideoItem> list = new ArrayList<>();

        list.add(new VideoItem(
                "Demo YouTube Video",
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                "https://i.ytimg.com/vi/dQw4w9WgXcQ/hqdefault.jpg"
        ));

        return list;
    }
}
