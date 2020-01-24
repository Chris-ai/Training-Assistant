package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ExcercisesActivity extends AppCompatActivity {

    public ArrayList<SpinnerListItem> LegList = new ArrayList<>();
    public ArrayList<SpinnerListItem> ArmsList = new ArrayList<>();
    public ArrayList<SpinnerListItem> ShouldersList = new ArrayList<>();
    public ArrayList<SpinnerListItem> AbsList = new ArrayList<>();
    public ArrayList<SpinnerListItem> ChestList = new ArrayList<>();
    public ArrayList<SpinnerListItem> BackList = new ArrayList<>();

    private Spinner LegsSpinner;
    private Spinner ShouldersSpinner;
    private Spinner ArmsSpinner;
    private Spinner AbsSpinner;
    private Spinner ChestSpinner;
    private Spinner BackSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);

        LegsSpinner = findViewById(R.id.legs_spinner);
        ShouldersSpinner = findViewById(R.id.shoulders_spinner);
        ArmsSpinner = findViewById(R.id.arms_spinner);
        AbsSpinner = findViewById(R.id.abs_spinner);
        ChestSpinner = findViewById(R.id.chest_spinner);
        BackSpinner = findViewById(R.id.back_spinner);


        ShouldersList.add(new SpinnerListItem(null,null,null));
        ShouldersList.add(new SpinnerListItem("@string/SoldierPush","@string/frontActonsofShoulders", "@stringSoldierPushDesc"));



        SpinnerAdapter LegsAdapter = new SpinnerAdapter(this, ShouldersList);
        SpinnerAdapter ChestAdapter = new SpinnerAdapter(this, ChestList);
        SpinnerAdapter ShouldersAdapter = new SpinnerAdapter(this, ShouldersList);
        SpinnerAdapter AbsAdapter = new SpinnerAdapter(this, AbsList);
        SpinnerAdapter ArmsAdapter = new SpinnerAdapter(this, ArmsList);
        SpinnerAdapter BackAdapter = new SpinnerAdapter(this, BackList);

        if(LegsSpinner != null){
            LegsSpinner.setAdapter(LegsAdapter);
        }

        if(ShouldersSpinner != null){
            ShouldersSpinner.setAdapter(LegsAdapter);
        }

        if(ArmsSpinner != null){
            ArmsSpinner.setAdapter(LegsAdapter);
        }

        if(ChestSpinner != null){
            ChestSpinner.setAdapter(LegsAdapter);
        }

        if(AbsSpinner != null){
            AbsSpinner.setAdapter(LegsAdapter);
        }

        if(BackSpinner != null){
            BackSpinner.setAdapter(LegsAdapter);
        }
    }
}

