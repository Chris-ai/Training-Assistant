package com.example.trainingassistant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private Button edit_button;
    public static final int EDIT_PROFILE_REQUEST_CODE = 1;
    private Person Person = new Person("Imię","Nazwisko",0,0,0,"płeć");
    private List<Person> personList = Collections.singletonList(Person);

    private TextView textViewName;
    private TextView textViewAge;
    private TextView textViewWeight;
    private TextView textViewHeight;
    private TextView textViewGender;
    private TextView textViewSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edit_button = findViewById(R.id.edit_button);

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

            assert data != null;
            String name = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_NAME);
            if(name != null && !name.equals("")) {
                textViewName.setText(name);
            }

            String surname = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_SURNAME);
            if(surname != null && !surname.equals("")) {
                textViewSurname.setText(surname);
            }

            int age = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_AGE, 0);
            if(age != 0) {
                textViewAge.setText(age);
            }

            int weight = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_WEIGHT, 0);
            if(weight !=0) {
                textViewWeight.setText(weight);
            }

            int height = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_HEIGHT, 0);
            if(height != 0) {
                textViewHeight.setText(height);
            }
            String gender = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_GENDER);
                textViewGender.setText(gender);
            Toast.makeText(ProfileActivity.this,"Profil zaktualizowany :)",Toast.LENGTH_LONG).show();
        }

    }
}
