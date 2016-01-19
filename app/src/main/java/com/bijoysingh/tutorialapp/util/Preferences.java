package com.bijoysingh.tutorialapp.util;

import android.content.Context;

import com.birdlabs.starter.util.PreferenceManager;

/**
 * Created by bijoy on 1/18/16.
 */
public class Preferences extends PreferenceManager {

    public Preferences(Context context) {
        super(context);
    }

    @Override
    public String getPreferencesFolder() {
        return "TutorialApp";
    }
}
