package com.bijoysingh.tutorialapp.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.item.NewsItem;
import com.github.bijoysingh.starter.recyclerview.RVHolder;

/**
 * The News View Holder for Recycler view for the news
 * Created by bijoy on 1/22/16.
 */
public class NewsViewHolder extends RVHolder<NewsItem> {

    TextView title;
    TextView description;
    TextView author;
    TextView category;

    public NewsViewHolder(Context context, View itemView) {
        super(context, itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        author = (TextView) itemView.findViewById(R.id.author);
        category = (TextView) itemView.findViewById(R.id.category);
    }

    @Override
    public void populate(final NewsItem data) {
        super.populate(data);
        title.setText(data.title);
        description.setText(data.description);
        category.setText(data.category);
        author.setText(data.name + ",\n" + data.post + ",\n" + data.council);
    }
}
