package com.example.youtubetv;

import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.localization.ContentCountry;
import org.schabi.newpipe.extractor.localization.Localization;


public class ExtractorInit {


    public static void init(){

        NewPipe.init(
                new DownloaderImpl()
        );


        NewPipe.setLocalization(
                new Localization(
                        "en",
                        ContentCountry.DEFAULT
                )
        );

    }
}
