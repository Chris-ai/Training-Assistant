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
    public static final String NOTE_SAVED = "Notateczka_zapisana";
    public static final String COUNTER_KEY = "Licznik";
    public static final String COUNTER_SAVED = "Licznik zapisany";
    public static final String SHARED_PREFS = "sharedPrefs";

    TextView meessageInSettings;
    TextView trainings_counter;
    TextView my_trainings_notes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        meessageInSettings = findViewById(R.id.message_in_settings);
        trainings_counter = findViewById(R.id.training_counter);
        my_trainings_notes = findViewById(R.id.your_trainings_notes);

        LoadData();
        saveData();
    }

   // @Override
/*  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MyTrainingActivity.NEW_ITEM_ACTIVITY_REQUEST_CODE) {
            SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            assert data != null;
            int counter = data.getIntExtra(MyTrainingActivity.USER_TRAININGS_COUNTER,0);
            int x = sharedPreferences.getInt(COUNTER_KEY,0);
            x += counter;
            editor.putInt(COUNTER_KEY,x);
            editor.apply();
            trainings_counter.setText(String.valueOf(sharedPreferences.getInt(COUNTER_KEY,0)));
        }
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        trainings_counter.setText(String.valueOf(sharedPreferences.getInt(COUNTER_KEY,0)));
        my_trainings_notes.setText(sharedPreferences.getInt(NOTE_SAVED,R.string.No_notes_detected));
    }



    public void LoadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(getIntent().hasExtra(NEW_TRAINING_NOTE) && getIntent().hasExtra(COUNTER_KEY)){
            editor.putString(NOTE_SAVED, getIntent().getStringExtra(NEW_TRAINING_NOTE));
            my_trainings_notes.setText(sharedPreferences.getString(NOTE_SAVED, getString(R.string.No_notes_detected)));
            editor.putInt(COUNTER_SAVED, getIntent().getIntExtra(COUNTER_KEY, 0));
            trainings_counter.setText(String.valueOf(sharedPreferences.getInt(COUNTER_SAVED, 0)));
        }
        editor.apply();
        Log.d("DaneInto", "Wczytanie danych");
    }


    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

            my_trainings_notes.setText(sharedPreferences.getString(NOTE_SAVED, getString(R.string.No_notes_detected)));
            trainings_counter.setText(String.valueOf(sharedPreferences.getInt(COUNTER_SAVED, 0)));
            Log.d("Dane", "Dodano nowe dane");
        }

}
