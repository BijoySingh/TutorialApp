package com.bijoysingh.tutorialapp.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.adapter.AppAdapter;
import com.bijoysingh.tutorialapp.item.AppItem;

import java.util.ArrayList;
import java.util.List;

public class AppsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
        loadAppsIntoRecyclerView();
    }

    public void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void loadAppsIntoRecyclerView() {
        List<AppItem> apps = getApps();
        AppAdapter adapter = new AppAdapter(this, apps);
        recyclerView.setAdapter(adapter);
    }

    public List<AppItem> getApps() {
        List<AppItem> apps = new ArrayList<>();

        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> installedApplications =
                packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo appInfo : installedApplications) {
            String packageName = appInfo.packageName;
            String appName = (String) appInfo.loadLabel(packageManager);
            Drawable appIcon = appInfo.loadIcon(packageManager);

            apps.add(new AppItem(appName, packageName, appIcon));
        }

        return apps;
    }

}
