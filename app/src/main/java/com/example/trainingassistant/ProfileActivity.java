package com.example.trainingassistant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class ProfileActivity extends AppCompatActivity {

    public static final int EDIT_PROFILE_REQUEST_CODE = 1;
    public static final String SHARED_PREFS = "sharedPrefs";

    private TextView textViewName;
    private TextView textViewAge;
    private TextView textViewWeight;
    private TextView textViewHeight;
    private TextView textViewGender;
    private TextView textViewSurname;

    private String name;
    private String surname;
    private String gender;
    private int age;
    private int weight;
    private int height;

    private ImageView profile_image;

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
        profile_image = findViewById(R.id.profile_image);


        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK ){

            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            assert data != null;
            name = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_NAME);
            if(name != null && !name.equals("")) {
              editor.putString("name", name);
                Log.d(String.valueOf(R.string.SharedPrefsLog),"Zapisano imię do SharedPreferences");
              editor.apply();
                textViewName.setText(sharedPreferences.getString("name",name));
            }

            surname = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_SURNAME);
            if(surname != null && !surname.equals("")) {
               editor.putString("surname",surname);
                Log.d(String.valueOf(R.string.SharedPrefsLog),"Zapisano nazwisko do SharedPreferences");
               editor.apply();
               textViewSurname.setText(sharedPreferences.getString("surname",surname));
            }

            age = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_AGE, 0);
            if(age != 0) {
               editor.putInt("age",age);
                Log.d(String.valueOf(R.string.SharedPrefsLog),"Zapisano wiek do SharedPreferences");
               editor.apply();
               textViewAge.setText(String.valueOf(sharedPreferences.getInt("age",age)));
            }

            weight = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_WEIGHT, 0);
            if(weight !=0) {
                editor.putInt("weight",weight);
                Log.d(String.valueOf(R.string.SharedPrefsLog),"Zapisano wagę do SzaredPreferences");
                editor.apply();
                textViewWeight.setText(String.valueOf(sharedPreferences.getInt("weight",weight)));
            }

            height = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_HEIGHT, 0);
            if(height != 0) {
               editor.putInt("height",height);
               editor.apply();
                Log.d(String.valueOf(R.string.SharedPrefsLog),"Zapisano wzrost do SharedPreferences");
               textViewHeight.setText(String.valueOf(sharedPreferences.getInt("height",height)));
            }

            gender = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_GENDER);
                editor.putString("gender",gender);
            Log.d(String.valueOf(R.string.SharedPrefsLog),"Zapisano płeć do SharedPreferences");
                textViewGender.setText(gender);

            editor.apply();

            Toast.makeText(ProfileActivity.this,"Profil zaktualizowany :)",Toast.LENGTH_LONG).show();
        } else if(resultCode == RESULT_CANCELED){
            Toast.makeText(ProfileActivity.this,"Nie uzupełniłeś wszystkich danych :(",Toast.LENGTH_LONG).show();
        }

    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        textViewName.setText(sharedPreferences.getString("name","Imię"));
        textViewSurname.setText(sharedPreferences.getString("surname","Nazwisko"));
        textViewAge.setText(String.valueOf(sharedPreferences.getInt("age",0)));
        textViewWeight.setText(String.valueOf(sharedPreferences.getInt("weight",0)));
        textViewHeight.setText(String.valueOf(sharedPreferences.getInt("height",0)));
        textViewGender.setText(sharedPreferences.getString("gender","none"));
        Log.d("Tag","Wczytano dane");

        if(sharedPreferences.getString("gender","none").equals("Mężczyzna")){
            profile_image.setImageResource(R.drawable.boy);
        } else if(sharedPreferences.getString("gender","none").equals("Kobieta")){
            profile_image.setImageResource(R.drawable.girl);
        }

    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", sharedPreferences.getString("name",name));
        editor.putString("surname",sharedPreferences.getString("surname",surname));
        editor.putInt("age",sharedPreferences.getInt("age",age));
        editor.putInt("weight",sharedPreferences.getInt("weight",weight));
        editor.putInt("height",sharedPreferences.getInt("height",height));
        editor.putString("gender",sharedPreferences.getString("gender",gender));
        editor.apply();

        Log.d("Tag","Zapisano Dane");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}
