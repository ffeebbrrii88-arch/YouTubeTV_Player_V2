package com.example.youtubetv;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;


public class VideoCardPresenter extends Presenter {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        Context context = parent.getContext();


        LinearLayout layout =
                new LinearLayout(context);

        layout.setOrientation(
                LinearLayout.VERTICAL
        );

        layout.setGravity(
                Gravity.CENTER
        );

        layout.setFocusable(true);
        layout.setFocusableInTouchMode(true);

        layout.setOnFocusChangeListener(
                (v, hasFocus) -> {

                    if(hasFocus){

                        v.animate()
                                .scaleX(1.08f)
                                .scaleY(1.08f)
                                .setDuration(150)
                                .start();

                    }else{

                        v.animate()
                                .scaleX(1.0f)
                                .scaleY(1.0f)
                                .setDuration(150)
                                .start();
                    }
                }
        );



        ImageView image =
                new ImageView(context);


        image.setLayoutParams(
                new LinearLayout.LayoutParams(
                        320,
                        180
                )
        );


        image.setBackgroundColor(
                Color.DKGRAY
        );


        TextView title =
                new TextView(context);


        title.setTextColor(
                Color.WHITE
        );


        title.setTextSize(18);


        title.setGravity(
                Gravity.CENTER
        );


        layout.addView(image);
        layout.addView(title);


        return new ViewHolder(layout);
    }



    @Override
    public void onBindViewHolder(
            ViewHolder holder,
            Object item
    ){

        LinearLayout layout =
                (LinearLayout)holder.view;


        ImageView image =
                (ImageView)layout.getChildAt(0);


        TextView title =
                (TextView)layout.getChildAt(1);



        if(item instanceof VideoItem){

            VideoItem video =
                    (VideoItem)item;


            title.setText(
                    video.title
            );


            if(video.thumbnail != null &&
                    !video.thumbnail.isEmpty()){


                Glide.with(
                        image.getContext()
                )
                .load(video.thumbnail)
                .into(image);

            }

        }

    }



    @Override
    public void onUnbindViewHolder(ViewHolder holder){

    }
}
