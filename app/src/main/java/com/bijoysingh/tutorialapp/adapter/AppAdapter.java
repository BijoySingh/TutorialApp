package com.bijoysingh.tutorialapp.adapter;

import android.content.Context;

import com.bijoysingh.tutorialapp.item.AppItem;
import com.bijoysingh.tutorialapp.view.AppViewHolder;
import com.birdlabs.starter.recyclerview.RVAdapter;

import java.util.List;

/**
 * Adapter for showing the apps
 * Created by bijoy on 1/17/16.
 */
public class AppAdapter extends RVAdapter<AppItem, AppViewHolder> {

    public AppAdapter(Context context, Integer layout, List<AppItem> contents) {
        super(context, layout, AppViewHolder.class);
        this.contents = contents;
    }

    @Override
    public List<AppItem> getValues() {
        return contents;
    }
}
