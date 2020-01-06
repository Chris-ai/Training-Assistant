package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_profile = findViewById(R.id.ProfileButton);
        Button button_excercises = findViewById(R.id.ExcercisesButton);
        Button button_mytraining = findViewById(R.id.TrainingButton);
        Button button_cardio = findViewById(R.id.HealthButton);
        Button button_about = findViewById(R.id.AboutButton);
        Button button_calendar = findViewById(R.id.CalendarButton);

        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


        button_excercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent excIntent = new Intent(MainActivity.this, ExcercisesActivity.class);
                MainActivity.this.startActivity(excIntent);
            }
        });


        button_mytraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyTrainingActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button_cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RunningActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }


}
