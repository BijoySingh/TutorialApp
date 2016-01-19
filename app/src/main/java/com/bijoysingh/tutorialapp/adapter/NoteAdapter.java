package com.bijoysingh.tutorialapp.adapter;

import android.content.Context;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.item.NoteItem;
import com.bijoysingh.tutorialapp.view.NoteViewHolder;
import com.birdlabs.starter.recyclerview.RVAdapter;

import java.util.List;

/**
 * Created by bijoy on 1/19/16.
 */
public class NoteAdapter extends RVAdapter<NoteItem, NoteViewHolder> {

    public NoteAdapter(Context context, List<NoteItem> notes) {
        super(context, R.layout.note_item, NoteViewHolder.class);
        contents = notes;
    }

    @Override
    public List<NoteItem> getValues() {
        return contents;
    }
}
