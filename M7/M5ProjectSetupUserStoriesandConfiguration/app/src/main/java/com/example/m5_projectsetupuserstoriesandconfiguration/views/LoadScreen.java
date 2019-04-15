package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player2;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.PlayerInformation;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Universe;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.LoadActivityViewModel;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.MainActivityViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * An activity that contains methods pertaining to the Load Screen
 */
public class LoadScreen extends AppCompatActivity {

    private int currentPlayerID;
    private Player currentPlayer;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private MainActivityViewModel mainVM;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ViewModelProvider mainVMs = ViewModelProviders.of(this);
        mainVM = mainVMs.get(MainActivityViewModel.class);

//        ViewModelProvider loadVMs = ViewModelProviders.of(this);
//        LoadActivityViewModel loadVM = loadVMs.get(LoadActivityViewModel.class);
//        try {
//            loadVM.loadBinary();
//        } catch (Exception e) {
//            //lol
//            Log.e("ERROR", "LOADING FAILED");
//        }

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                currentPlayer = showData(dataSnapshot);
                currentPlayerID = currentPlayer.getId();
                //String value = dataSnapshot.getValue(String.class);
                //Log.d("TAG", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });


    }

    private Player showData(DataSnapshot dataSnapshot) {
        Player result = null;
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Player p = new Player(ds.getValue(PlayerInformation.class).getName(),
                    ds.getValue(PlayerInformation.class).getFighterPoints(),
                    ds.getValue(PlayerInformation.class).getTraderPoints(),
                    ds.getValue(PlayerInformation.class).getEngineerPoints(),
                    ds.getValue(PlayerInformation.class).getPilotPoints(),
                    ds.getValue(PlayerInformation.class).getDiff(),
                    new Universe(15));
            result = p;
        }
        return result;
    }


    /**
     * An onClick method that returns to the previous activity when a button is clicked
     * @param view the View of the button
     */
    public void onGoBackPressed(View view) {
        startActivity(new Intent(this, MainMenu.class));
        Log.i("Test", "Returning to Main Menu");
    }

    /**
     * An onClick method that returns to a new activity with the generated player information
     * @param view the View of the button
     */
    public void onLoadGamePressed(View view) {

        Toast toast = Toast.makeText(this, "LET ME IN!!!!", LENGTH_SHORT);
        toast.show();
        Intent moveActivities = new Intent(this, PlanetScreen.class);

        mainVM.addPlayer(currentPlayer);
        ModelSingleton.setCurrentPlayerID(currentPlayer.getId());

        startActivity(moveActivities);

    }

}
