package com.bijoysingh.tutorialapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.bijoysingh.tutorialapp.R;
import com.bijoysingh.tutorialapp.util.Preferences;
import com.birdlabs.starter.Functions;

public class StartActivity extends AppCompatActivity {

    private final static String NAME_KEY = "NAME";
    private EditText name;
    private Switch save;
    private Preferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        preference = new Preferences(this);
        name = (EditText) findViewById(R.id.name);
        name.setText(preference.load(NAME_KEY, ""));
        save = (Switch) findViewById(R.id.save);

        Button apps = (Button) findViewById(R.id.apps);
        apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleStart();
                openAppsActivity();
            }
        });

        Button notes = (Button) findViewById(R.id.notes);
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleStart();
                openNotesActivity();
            }
        });
    }

    public void handleStart() {
        if (save.isChecked()) {
            preference.save(NAME_KEY, name.getText().toString());
        }
        Functions.makeToast(getApplicationContext(), "Hello, " + name.getText().toString());
    }

    public void openAppsActivity() {
        Intent appsActivityIntent = new Intent(getApplicationContext(), AppsActivity.class);
        startActivity(appsActivityIntent);
        finish();
    }

    public void openNotesActivity() {
        Intent appsActivityIntent = new Intent(getApplicationContext(), NotesActivity.class);
        startActivity(appsActivityIntent);
        finish();
    }
}
