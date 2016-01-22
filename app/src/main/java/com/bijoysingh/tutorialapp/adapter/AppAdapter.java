package com.bijoysingh.tutorialapp.adapter;

import android.content.Context;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.item.AppItem;
import com.bijoysingh.tutorialapp.view.AppViewHolder;
import com.github.bijoysingh.starter.recyclerview.RVAdapter;

import java.util.List;

/**
 * Adapter for showing the apps
 * Created by bijoy on 1/17/16.
 */
public class AppAdapter extends RVAdapter<AppItem, AppViewHolder> {

    public AppAdapter(Context context, List<AppItem> contents) {
        super(context, R.layout.app_item, AppViewHolder.class);
        this.contents = contents;
    }

    @Override
    public List<AppItem> getValues() {
        return contents;
    }
}
