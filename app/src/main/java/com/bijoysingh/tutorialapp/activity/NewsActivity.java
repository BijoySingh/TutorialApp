package com.bijoysingh.tutorialapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.adapter.NewsAdapter;
import com.bijoysingh.tutorialapp.item.NewsItem;
import com.bijoysingh.tutorialapp.server.Access;
import com.github.bijoysingh.starter.server.AccessItem;
import com.github.bijoysingh.starter.util.FileManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    public static final String FILENAME = "NEWS_FILE.txt";

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    NewsAdapter adapter;
    List<NewsItem> news = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
    }

    public void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NewsAdapter(this, this);
        recyclerView.setAdapter(adapter);
    }

    public void refreshList() {
        news = new ArrayList<>();
        try {
            String fileData = FileManager.read(this, FILENAME);
            JSONObject jsonObject = new JSONObject(fileData);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (Integer position = 0; position < jsonArray.length(); position++) {
                JSONObject json = jsonArray.getJSONObject(position);
                NewsItem item = new NewsItem(json);
                news.add(item);
            }
        } catch (Exception exception) {
            Log.e(NewsActivity.class.getSimpleName(), exception.getMessage(), exception);
        }
        adapter.notifyDataSetChanged();
    }

    public List<NewsItem> getValues() {
        return news;
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
        new Access(this).get(new AccessItem("http://gymkhana.iitb.ac.in/~hostel5/api/app/news.php",
                FILENAME, Access.AccessIds.NEWS, false).setActivity(this));
    }
}
