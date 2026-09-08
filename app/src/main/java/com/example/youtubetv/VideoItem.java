package com.example.youtubetv;

public class VideoItem {

    public String title;
    public String url;
    public String thumbnail;


    public VideoItem(
            String title,
            String url,
            String thumbnail
    ){

        this.title = title;
        this.url = url;
        this.thumbnail = thumbnail;

    }


    @Override
    public String toString(){

        return title;

    }
}
