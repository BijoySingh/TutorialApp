package com.bijoysingh.tutorialapp.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.item.AppItem;
import com.birdlabs.starter.recyclerview.RVHolder;

/**
 * App View Holder
 * Created by bijoy on 1/17/16.
 */
public class AppViewHolder extends RVHolder<AppItem> {

    ImageView appIcon;
    TextView appName;
    TextView appPackage;

    public AppViewHolder(Context context, View itemView) {
        super(context, itemView);
        appIcon = (ImageView) itemView.findViewById(R.id.app_icon);
        appName = (TextView) itemView.findViewById(R.id.app_name);
        appPackage = (TextView) itemView.findViewById(R.id.app_package);
    }

    @Override
    public void populate(final AppItem data) {
        super.populate(data);
        appIcon.setImageDrawable(data.appIcon);
        appName.setText(data.appName);
        appPackage.setText(data.appPackage);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LaunchIntent =  context.getPackageManager()
                        .getLaunchIntentForPackage(data.appPackage);
                context.startActivity(LaunchIntent);
            }
        });
    }
}
