package com.example.youtubetv;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

public class VideoCardPresenter extends Presenter {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        TextView view = new TextView(parent.getContext());

        view.setTextSize(24);
        view.setPadding(40,40,40,40);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(
            ViewHolder viewHolder,
            Object item) {

        ((TextView)viewHolder.view)
                .setText(item.toString());
    }


    @Override
    public void onUnbindViewHolder(
            ViewHolder viewHolder) {

    }
}
