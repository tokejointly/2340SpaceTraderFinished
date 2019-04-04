package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.LoadActivityViewModel;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class LoadScreen extends AppCompatActivity {

    private LoadActivityViewModel loadVM;
    private TextView currentPlayerID;
    private Player currentPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        loadVM = ViewModelProviders.of(this).get(LoadActivityViewModel.class);
        try {
            loadVM.loadBinary(openFileInput("data.bin"));
        } catch (Exception e) {
            //lol
            Log.e("ERROR", "LOADING FAILED");
        }
    }


    public void onGoBackPressed(View view) {
        startActivity(new Intent(this, MainMenu.class));
        Log.i("Test", "Returning to Main Menu");
    }

    public void onLoadGamePressed(View view) {
        Intent moveActivities = new Intent(this, PlanetScreen.class);
        int id = ModelSingleton.getCurrentPlayerID();
        currentPlayer = loadVM.getPlayer(id);
        Toast.makeText(this, currentPlayer.getName(), LENGTH_SHORT);

        //startActivity(moveActivities);
    }

}
