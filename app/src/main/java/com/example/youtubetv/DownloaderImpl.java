package com.example.youtubetv;

import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Request;
import org.schabi.newpipe.extractor.downloader.Response;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.ResponseBody;

public class DownloaderImpl extends Downloader {

    private final OkHttpClient client =
            new OkHttpClient();


    @Override
    public Response execute(
            Request request
    ) throws IOException {


        okhttp3.Request okRequest =
                new Builder()
                        .url(request.url())
                        .build();


        okhttp3.Response response =
                client.newCall(okRequest)
                        .execute();


        ResponseBody body =
                response.body();


        String responseBody =
                body != null
                        ? body.string()
                        : "";


        return new Response(
                response.code(),
                response.message(),
                response.headers().toMultimap(),
                responseBody
        );
    }
}
