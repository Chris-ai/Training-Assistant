package com.example.trainingassistant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class ProfileActivity extends AppCompatActivity {

    public static final int EDIT_PROFILE_REQUEST_CODE = 1;

    private TextView textViewName;
    private TextView textViewAge;
    private TextView textViewWeight;
    private TextView textViewHeight;
    private TextView textViewGender;
    private TextView textViewSurname;

    private String name, surname, gender;
    private int age, weight, height;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button edit_button = findViewById(R.id.edit_button);

        textViewName = findViewById(R.id.name);
        textViewAge = findViewById(R.id.how_many_years);
        textViewHeight = findViewById(R.id.how_many_cm);
        textViewWeight = findViewById(R.id.how_many_kg);
        textViewGender = findViewById(R.id.gender);
        textViewSurname = findViewById(R.id.surname);


        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivityForResult(intent,EDIT_PROFILE_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK ){

            SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            assert data != null;
            name = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_NAME);
            if(name != null && !name.equals("")) {
              editor.putString("name", name);
                textViewName.setText(sharedPreferences.getString("name","Imię"));
            }

            surname = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_SURNAME);
            if(surname != null && !surname.equals("")) {
               editor.putString("surname",surname);
               textViewSurname.setText(sharedPreferences.getString("surname","Nazwisko"));
            }

            age = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_AGE, 0);
            if(age != 0) {
               editor.putInt("age",age);
               textViewAge.setText(String.valueOf(sharedPreferences.getInt("age",0)));
            }

            weight = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_WEIGHT, 0);
            if(weight !=0) {
                editor.putInt("weight",weight);
                textViewWeight.setText(String.valueOf(sharedPreferences.getInt("weight",0)));
            }

            height = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_HEIGHT, 0);
            if(height != 0) {
               editor.putInt("height",height);
               textViewHeight.setText(String.valueOf(sharedPreferences.getInt("height",0)));
            }

            gender = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_GENDER);
                editor.putString("gender",gender);
                textViewGender.setText(sharedPreferences.getString("gender","none"));

            editor.apply();
            Toast.makeText(ProfileActivity.this,"Profil zaktualizowany :)",Toast.LENGTH_LONG).show();
        } else if(resultCode == RESULT_CANCELED){
            Toast.makeText(ProfileActivity.this,"Nie uzupełniłeś wszystkich danych :(",Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", name);
        editor.putString("surname",surname);
        editor.putInt("age",age);
        editor.putInt("weight",weight);
        editor.putInt("height",height);
        editor.putString("gender",gender);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        textViewName.setText(sharedPreferences.getString("name","Imię"));
        textViewSurname.setText(sharedPreferences.getString("surname","Nazwisko"));
        textViewAge.setText(String.valueOf(sharedPreferences.getInt("age",0)));
        textViewWeight.setText(String.valueOf(sharedPreferences.getInt("weight",0)));
        textViewHeight.setText(String.valueOf(sharedPreferences.getInt("height",0)));
        textViewGender.setText(sharedPreferences.getString("gender","none"));
    }
}
