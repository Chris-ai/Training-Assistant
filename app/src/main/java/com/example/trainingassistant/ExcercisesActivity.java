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


        SpinnerAdapter LegsAdapter = new SpinnerAdapter(this, LegList);
        SpinnerAdapter ChestAdapter = new SpinnerAdapter(this, ChestList);
        SpinnerAdapter ShouldersAdapter = new SpinnerAdapter(this, ShouldersList);
        SpinnerAdapter AbsAdapter = new SpinnerAdapter(this, AbsList);
        SpinnerAdapter ArmsAdapter = new SpinnerAdapter(this, ArmsList);
        SpinnerAdapter BackAdapter = new SpinnerAdapter(this, BackList);

        if(LegsSpinner != null){
            LegsSpinner.setAdapter(LegsAdapter);
        }

        if(ShouldersSpinner != null){
            ShouldersSpinner.setAdapter(ShouldersAdapter);
        }

        if(ArmsSpinner != null){
            ArmsSpinner.setAdapter(ArmsAdapter);
        }

        if(ChestSpinner != null){
            ChestSpinner.setAdapter(ChestAdapter);
        }

        if(AbsSpinner != null){
            AbsSpinner.setAdapter(AbsAdapter);
        }

        if(BackSpinner != null){
            BackSpinner.setAdapter(BackAdapter);
        }

        /**
         * Inicjalizacja listy ćwiczeń na barki
         */
        ShouldersList.add(new SpinnerListItem(null,null,null));
        ShouldersList.add(new SpinnerListItem(getString(R.string.ShouldersOne),
                getString(R.string.ShouldersOneMuscle),
                getString(R.string.ShouldersOneDesc)));
        ShouldersList.add(new SpinnerListItem(getString(R.string.ShouldersTwo),
                getString(R.string.ShouldersTwoMuscle),getString(R.string.ShouldersTwoDesc)));
        ShouldersList.add(new SpinnerListItem(getString(R.string.ShouldersThree),getString(R.string.ShouldersThreeMuscle),
                getString(R.string.ShouldersThreeDesc)));
        ShouldersList.add(new SpinnerListItem(getString(R.string.ShouldersFour),getString(R.string.ShouldersFourMuscle),
                getString(R.string.ShouldersFourDesc)));

        /**
         * Inicjalizacja listy ćwiczeń na Klatkę
         */

        ChestList.add(new SpinnerListItem(null,null,null));
        ChestList.add(new SpinnerListItem(getString(R.string.ChestOne),
                getString(R.string.ChestOneMuscle),getString(R.string.ChestOneDesc)));
        ChestList.add(new SpinnerListItem(getString(R.string.ChestTwo),
                getString(R.string.ChestTwoMuscle),getString(R.string.ChestTwoDesc)));
        ChestList.add(new SpinnerListItem(getString(R.string.ChestThree),
                getString(R.string.ChestThreeMuscle),getString(R.string.ChestThreeDesc)));
        ChestList.add(new SpinnerListItem(getString(R.string.ChestFour),
                getString(R.string.ChestFourMuscle),getString(R.string.ChestFourDesc)));

        /**
         * Inicjalizacja listy ćwiczeń na Plecy
         */

        BackList.add(new SpinnerListItem(null,null,null));
        BackList.add(new SpinnerListItem(getString(R.string.BackOne),
                getString(R.string.BackOneMuscle),getString(R.string.BackOneDesc)));
        BackList.add(new SpinnerListItem(getString(R.string.BackTwo),
                getString(R.string.BackTwoMuscle),getString(R.string.BackTwoDesc)));
        BackList.add(new SpinnerListItem(getString(R.string.BackThree),
                getString(R.string.BackThreeMuscle),getString(R.string.BackThreeDesc)));

        /**
         * Inicjalizacja listy ćwiczeń na Ręce
         */
        ArmsList.add(new SpinnerListItem(null,null,null));
        ArmsList.add(new SpinnerListItem(getString(R.string.ArmsOne),
                getString(R.string.ArmsOneMuscle),getString(R.string.ArmsOneDesc)));
        ArmsList.add(new SpinnerListItem(getString(R.string.ArmsTwo),
                getString(R.string.ArmsTwoMuscle),
                getString(R.string.ArmsTwoDesc)));
        ArmsList.add(new SpinnerListItem(getString(R.string.ArmsThree),
                getString(R.string.ArmsThreeMuscle),
                getString(R.string.ArmsThreeDesc)));
        ArmsList.add(new SpinnerListItem(getString(R.string.ArmsFour),
                getString(R.string.ArmsFourMuscle),
                getString(R.string.ArmsFourDesc)));
        ArmsList.add(new SpinnerListItem(getString(R.string.ArmsFive),
                getString(R.string.ArmsFiveMuscle),getString(R.string.ArmsFiveDesc)));

        /**
         * Inicjalizacja listy ćwiczeń na Brzuch
         */
        AbsList.add(new SpinnerListItem(null,null,null));
        AbsList.add(new SpinnerListItem(getString(R.string.AbsOne),
                getString(R.string.AbsOneMuscle),getString(R.string.AbsOneDesc)));
        AbsList.add(new SpinnerListItem(getString(R.string.AbsTwo),
                getString(R.string.AbsTwoMuscle),getString(R.string.AbsTwoDesc)));
        AbsList.add(new SpinnerListItem(getString(R.string.AbsThree),getString(R.string.AbsThreeMuscle),
                getString(R.string.AbsThreeDesc)));

        /**
         * Inicjalizacja listy ćwiczeń na Nogi
         */
        LegList.add(new SpinnerListItem(null,null,null));
        LegList.add(new SpinnerListItem(getString(R.string.LegsOne),
                getString(R.string.LegsOneMuscle),
                getString(R.string.LegsOneDesc)));
        LegList.add(new SpinnerListItem(getString(R.string.LegsTwo),
                getString(R.string.LegsTwoMuscle),getString(R.string.LegsTwoDesc)));
        LegList.add(new SpinnerListItem(getString(R.string.LegsThree),
                getString(R.string.LegsThreeMuscle),getString(R.string.LegsThreeDesc)));
        LegList.add(new SpinnerListItem(getString(R.string.LegsFouur),
                getString(R.string.LegsFourMuscle),getString(R.string.LegsFourDesc)));
    }
}

