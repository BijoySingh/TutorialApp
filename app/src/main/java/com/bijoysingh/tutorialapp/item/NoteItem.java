package com.bijoysingh.tutorialapp.item;

import com.github.bijoysingh.starter.database.DBColumn;
import com.github.bijoysingh.starter.database.DatabaseModel;

/**
 * Created by bijoy on 1/19/16.
 */
public class NoteItem extends DatabaseModel {
    @DBColumn(primaryKey = true, autoIncrement = true)
    public Integer id;

    @DBColumn
    public String title;

    @DBColumn
    public String description;

    public NoteItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public NoteItem() {
    }
}
