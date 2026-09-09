package com.example.youtubetv;

import org.schabi.newpipe.extractor.NewPipe;

public class ExtractorInit {

    private static boolean initialized = false;


    public static void init() {

        if(initialized) {
            return;
        }


        NewPipe.init(
                new DownloaderImpl()
        );


        initialized = true;
    }
}
