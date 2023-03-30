package com.biss.smartreminders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsScreen extends AppCompatActivity {

    private Button settingsCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen2);

        settingsCancel = (Button) findViewById(R.id.settingsCancel);
        settingsCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadActivity = new Intent(SettingsScreen.this, MainActivity.class);
                startActivity(intentLoadActivity);
            }
        });
    }
}