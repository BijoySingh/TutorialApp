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

    private final static String SAVED_KEY = "SAVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        final Preferences preference = new Preferences(this);
        if (preference.load(SAVED_KEY, false)) {
            openAppsActivity();
        }

        final EditText name = (EditText) findViewById(R.id.name);
        final Switch save = (Switch) findViewById(R.id.save);

        Button start = (Button) findViewById(R.id.submit);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (save.isChecked()) {
                    preference.save(SAVED_KEY, true);
                }

                Functions.makeToast(getApplicationContext(), "Hello, " + name.getText().toString());
                openAppsActivity();
            }
        });
    }

    public void openAppsActivity() {
        Intent appsActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(appsActivityIntent);
        finish();
    }
}
