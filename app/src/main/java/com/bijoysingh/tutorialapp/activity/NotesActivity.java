package com.bijoysingh.tutorialapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.adapter.NoteAdapter;
import com.bijoysingh.tutorialapp.item.NoteItem;
import com.bijoysingh.tutorialapp.util.Preferences;
import com.birdlabs.starter.database.DatabaseManager;
import com.birdlabs.starter.database.DatabaseModel;

import java.util.List;

public class NotesActivity extends AppCompatActivity {

    private final static String POPULATED = "POPULATED";

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        db = new DatabaseManager(this, new DatabaseModel[]{new NoteItem()});
        addStarterData();
        setupRecyclerView();
        loadNotesIntoRecyclerView();
    }

    public void addStarterData() {
        Preferences preferences = new Preferences(this);
        if (preferences.load(POPULATED, false)) {
            return;
        }
        NoteItem item;
        item = new NoteItem("Generic Note", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.");
        db.add(item);
        item = new NoteItem("Android Tutorial Guidelines", "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.");
        db.add(item);
        item = new NoteItem("Work Out Routine", "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet.");
        db.add(item);

        preferences.save(POPULATED, true);
    }

    public void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void loadNotesIntoRecyclerView() {
        List<NoteItem> apps = db.get(NoteItem.class);
        NoteAdapter adapter = new NoteAdapter(this, apps);
        recyclerView.setAdapter(adapter);
    }

}
