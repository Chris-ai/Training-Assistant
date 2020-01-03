package com.example.trainingassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button_profile;
    private Button button_excercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_profile = findViewById(R.id.ProfileButton);
        button_excercises = findViewById(R.id.ExcercisesButton);

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
    }


}
