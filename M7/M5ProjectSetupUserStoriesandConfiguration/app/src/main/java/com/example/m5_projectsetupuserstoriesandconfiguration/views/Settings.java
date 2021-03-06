package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

/**
 * An activity that contains methods pertaining to the Settings Screen
 */
public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Switch music = findViewById(R.id.music_toggle);
        music.setChecked(true);
        //Boolean isOn = music.isChecked();
    }

    /**
     * an onClick method that allows you to go back to the main menu
     * @param view the view for the button
     */
    public void onBackPressed(View view) {
        startActivity(new Intent(this, MainMenu.class));
        Log.i("Test", "Returning to Main Menu");
    }

}
