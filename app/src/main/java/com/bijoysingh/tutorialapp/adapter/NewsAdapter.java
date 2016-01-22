package com.bijoysingh.tutorialapp.adapter;

import android.content.Context;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.activity.NewsActivity;
import com.bijoysingh.tutorialapp.item.NewsItem;
import com.bijoysingh.tutorialapp.view.NewsViewHolder;
import com.github.bijoysingh.starter.recyclerview.RVAdapter;

import java.util.List;

/**
 * Created by bijoy on 1/22/16.
 */
public class NewsAdapter extends RVAdapter<NewsItem, NewsViewHolder> {

    NewsActivity activity;

    public NewsAdapter(Context context, NewsActivity activity) {
        super(context, R.layout.news_item, NewsViewHolder.class);
        this.activity = activity;
    }

    @Override
    public List<NewsItem> getValues() {
        return activity.getValues();
    }
}