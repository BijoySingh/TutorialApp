package com.bijoysingh.tutorialapp.item;

import android.graphics.drawable.Drawable;

import com.birdlabs.starter.database.DatabaseModel;

/**
 * Created by bijoy on 1/17/16.
 */
public class AppItem {
    public String appName;
    public String appPackage;
    public Drawable appIcon;

    public AppItem(String appName, String appPackage, Drawable appIcon) {
        this.appName = appName;
        this.appPackage = appPackage;
        this.appIcon = appIcon;
    }
}
