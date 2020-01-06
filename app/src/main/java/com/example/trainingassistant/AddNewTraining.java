package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class AddNewTraining extends AppCompatActivity {

    public static final String EXTRA_TRAINING_NAME = "NEW_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_training);

        EditText editTextTrainingName = findViewById(R.id.edit_name_training);
        Button saveButton = findViewById(R.id.button_add_training);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                String name = editTextTrainingName.getText().toString();
                returnIntent.putExtra(EXTRA_TRAINING_NAME, name);

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
