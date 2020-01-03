package com.example.trainingassistant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private Button edit_button;
    public static final int EDIT_PROFILE_REQUEST_CODE = 1;

    private TextView textViewName;
    private TextView textViewAge;
    private TextView textViewWeight;
    private TextView textViewHeight;
    private TextView textViewGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edit_button = findViewById(R.id.edit_button);
        textViewName = findViewById(R.id.name);
        textViewAge = findViewById(R.id.profile_age);
        textViewHeight = findViewById(R.id.profile_height);
        textViewWeight = findViewById(R.id.profile_weight);
        textViewGender = findViewById(R.id.profile_gender);

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

            String name = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_NAME);
            textViewName.setText(name);

            int age = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_AGE, 0);
               textViewAge.setText(age);

            int weight = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_WEIGHT, 0);
            textViewWeight.setText(weight);

            int height = data.getIntExtra(EditProfileActivity.EXTRA_EDIT_HEIGHT, 0);
            textViewHeight.setText(height);

            String gender = data.getStringExtra(EditProfileActivity.EXTRA_EDIT_GENDER);
            textViewGender.setText(gender);

            Toast.makeText(ProfileActivity.this,"Profil zaktualizowany :)",Toast.LENGTH_LONG).show();
        }

    }
}
