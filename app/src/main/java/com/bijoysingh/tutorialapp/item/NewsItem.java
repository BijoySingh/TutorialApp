package com.bijoysingh.tutorialapp.item;

import com.github.bijoysingh.starter.json.JsonField;
import com.github.bijoysingh.starter.json.JsonModel;

import org.json.JSONObject;

/**
 * News Item
 * Created by bijoy on 1/22/16.
 */
public class NewsItem extends JsonModel {

    @JsonField
    public String id;
    @JsonField
    public String title;
    @JsonField
    public String description;
    @JsonField
    public String category;
    @JsonField(field = "create_timestamp")
    public String timestamp;
    @JsonField
    public String name;
    @JsonField
    public String council;
    @JsonField
    public String post;

    public NewsItem(JSONObject json) throws Exception {
        super(json);
    }
}
