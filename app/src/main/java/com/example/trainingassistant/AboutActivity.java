package com.example.trainingassistant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    public static final String NEW_TRAINING_NOTE = "Notatka";
    public static final String COUNTER_KEY = "Licznik";

    public static final String NOTE_SAVED = "Notateczka_zapisana";
    public static final String COUNTER_SAVED = "Licznik zapisany";

    public static final String SHARED_PREFS = "sharedPrefs";

    TextView trainings_counter;
    TextView my_trainings_notes;

    private int counter;
    private String notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        trainings_counter = findViewById(R.id.training_counter);
        my_trainings_notes = findViewById(R.id.your_trainings_notes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        trainings_counter.setText(String.valueOf(sharedPreferences.getInt(COUNTER_SAVED,0)));
        my_trainings_notes.setText(sharedPreferences.getString(NOTE_SAVED,String.valueOf(R.string.No_notes_detected)));
        Log.d("Dane","Załadowano odbyte treningi");
    }


    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(COUNTER_SAVED,counter);
        Log.d("Counter","Dodano licznik do SharedPreferences");
        editor.putString(NOTE_SAVED,notes);
        Log.d("Notes","Dodano notatki do SharedPreferences");

        editor.apply();

    }
}
