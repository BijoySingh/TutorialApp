package com.bijoysingh.tutorialapp.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.item.NoteItem;
import com.birdlabs.starter.recyclerview.RVHolder;

/**
 * Created by bijoy on 1/19/16.
 */
public class NoteViewHolder extends RVHolder<NoteItem> {

    TextView title;
    TextView description;

    public NoteViewHolder(Context context, View itemView) {
        super(context, itemView);

        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
    }

    @Override
    public void populate(NoteItem data) {
        super.populate(data);
        title.setText(data.title);
        description.setText(data.description);
    }
}
