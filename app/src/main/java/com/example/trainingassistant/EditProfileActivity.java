package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EditProfileActivity extends AppCompatActivity {

    public static final String EXTRA_EDIT_NAME = "EDIT_NAME";
    public static final String EXTRA_EDIT_AGE = "EDIT_AGE";
    public static final String EXTRA_EDIT_WEIGHT = "EDIT_WEIGHT";
    public static final String EXTRA_EDIT_HEIGHT = "EDIT_HEIGHT";
    public static final String EXTRA_EDIT_GENDER = "EDIT_GENDER";
    public static final String EXTRA_EDIT_SURNAME = "EDIT_SURNAME";

    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextAge;
    private EditText editTextWeight;
    private EditText editTextHeight;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editTextName = findViewById(R.id.edit_name);
        editTextSurname = findViewById(R.id.edit_surname);
        editTextAge = findViewById(R.id.edit_age);
        editTextHeight = findViewById(R.id.edit_height);
        editTextWeight = findViewById(R.id.edit_weight);
        radioGroup = findViewById(R.id.radio_group);

       final Button button_save = findViewById(R.id.button_save);


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(editTextName.getText().toString().isEmpty() ||
                        editTextSurname.getText().toString().isEmpty() ||
                        editTextAge.getText().toString().isEmpty() ||
                        editTextWeight.getText().toString().isEmpty() ||
                        editTextHeight.getText().toString().isEmpty()
                )
                {
                    Toast.makeText(EditProfileActivity.this, "Nie uzupełniłeś wszystkich danych",Toast.LENGTH_LONG).show();
                } else {
                    Intent returnIntent = new Intent();

                    String name = editTextName.getText().toString();
                    String surname = editTextSurname.getText().toString();

                    returnIntent.putExtra(EXTRA_EDIT_NAME, name);
                    returnIntent.putExtra(EXTRA_EDIT_SURNAME, surname);

                    int age = Integer.parseInt(editTextAge.getText().toString());
                    returnIntent.putExtra(EXTRA_EDIT_AGE, age);

                    int weight = Integer.parseInt(editTextWeight.getText().toString());
                    returnIntent.putExtra(EXTRA_EDIT_WEIGHT, weight);

                    int height = Integer.parseInt(editTextHeight.getText().toString());
                    returnIntent.putExtra(EXTRA_EDIT_HEIGHT, height);
                    setResult(RESULT_OK, returnIntent);

                    int radioID = radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(radioID);

                    String gender = radioButton.getText().toString();
                    returnIntent.putExtra(EXTRA_EDIT_GENDER,gender);
                }

                finish();
            }


        });




    }
}
