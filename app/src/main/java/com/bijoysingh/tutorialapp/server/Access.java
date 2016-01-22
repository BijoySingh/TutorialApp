package com.bijoysingh.tutorialapp.server;

import android.content.Context;

import com.bijoysingh.tutorialapp.activity.NewsActivity;
import com.github.bijoysingh.starter.server.AccessItem;
import com.github.bijoysingh.starter.server.AccessManager;
import com.github.bijoysingh.starter.util.FileManager;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by bijoy on 1/22/16.
 */
public class Access extends AccessManager {

    public Access(Context context) {
        super(context);
    }

    @Override
    public Map<String, String> getAuthenticationData() {
        return null;
    }

    @Override
    public void handleGetResponse(AccessItem access, String s) {
        writeInFile(s, access);
        if (access.activity != null) {
            if (access.type.equals(AccessIds.NEWS)) {
                ((NewsActivity) access.activity).refreshList();
            }
        }
    }

    @Override
    public void handleSendResponse(AccessItem accessItem, JSONObject jsonObject) {

    }

    @Override
    public void handleGetError(AccessItem accessItem, com.android.volley.VolleyError volleyError) {

    }

    @Override
    public void handleSendError(AccessItem accessItem, com.android.volley.VolleyError volleyError) {

    }

    public void writeInFile(String response, AccessItem accessItem) {
        if (accessItem.filename != null && !accessItem.filename.isEmpty()) {
            FileManager.write(context, accessItem.filename, response);
        }
    }

    public static class AccessIds {
        public static final Integer NEWS = 0;
    }
}
