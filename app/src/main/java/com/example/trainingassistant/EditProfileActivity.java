package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EditProfileActivity extends AppCompatActivity {

    public static final String EXTRA_EDIT_NAME = "EDIT_NAME";
    public static final String EXTRA_EDIT_AGE = "EDIT_AGE";
    public static final String EXTRA_EDIT_WEIGHT = "EDIT_WEIGHT";
    public static final String EXTRA_EDIT_HEIGHT = "EDIT_HEIGHT";
    public static final String EXTRA_EDIT_GENDER = "EDIT_GENDER";

    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextAge;
    private EditText editTextWeight;
    private EditText editTextHeight;
    private CheckBox male;
    private CheckBox female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editTextName = findViewById(R.id.edit_name);
        editTextSurname = findViewById(R.id.edit_surname);
        editTextAge = findViewById(R.id.edit_age);
        editTextHeight = findViewById(R.id.edit_height);
        editTextWeight = findViewById(R.id.edit_weight);
        male = findViewById(R.id.checkBoxMale);
        female = findViewById(R.id.checkBoxFemale);

       final Button button_save = findViewById(R.id.button_save);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextName.getText().toString().isEmpty() ||
                        editTextSurname.getText().toString().isEmpty() ||
                        editTextAge.getText().toString().isEmpty() ||
                        editTextWeight.getText().toString().isEmpty() ||
                        editTextHeight.getText().toString().isEmpty() ||
                        (!male.isChecked() && !female.isChecked())
                )
                {
                    Toast.makeText(EditProfileActivity.this, "Uzupełnij dane pls",Toast.LENGTH_LONG).show();
                } else {
                    Intent returnIntent = new Intent();
                    StringBuilder profile_name = new StringBuilder();

                    String name = editTextName.getText().toString();
                    String surname = editTextSurname.getText().toString();

                    profile_name.append(name).append(" ").append(surname);
                    returnIntent.putExtra(EXTRA_EDIT_NAME, name);

                    int Age = Integer.parseInt(editTextAge.getText().toString());
                    returnIntent.putExtra(EXTRA_EDIT_AGE, Age);

                    int Weight = Integer.parseInt(editTextWeight.getText().toString());
                    returnIntent.putExtra(EXTRA_EDIT_WEIGHT, Weight);

                    int Height = Integer.parseInt(editTextHeight.getText().toString());
                    returnIntent.putExtra(EXTRA_EDIT_HEIGHT, Height);

                    if (male.isChecked()) {
                        String gender = "Mężczyzna";
                        returnIntent.putExtra(EXTRA_EDIT_GENDER, gender);
                    } else {
                        String gender = "Kobieta";
                        returnIntent.putExtra(EXTRA_EDIT_GENDER, gender);
                    }

                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
            }


        });




    }
}
