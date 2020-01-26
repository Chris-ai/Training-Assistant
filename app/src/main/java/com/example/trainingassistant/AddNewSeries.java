package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewSeries extends AppCompatActivity {

    public static final String EXTRA_EDIT_TRAINING_NAME = "myTrainingName";
    public static final String EXTRA_EDIT_TRAINING_LOAD = "myTrainingLoad";
    public static final String EXTRA_EDIT_TRAINING_REPS = "myTrainingReps";
    public static final String EXTRA_EDIT_TRAINING_POSITION = "position";

    private EditText editTrainingName;
    private EditText editTrainingLoad;
    private EditText editTrainingReps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_series);

        editTrainingName = findViewById(R.id.nameofexcercise);
        editTrainingLoad = findViewById(R.id.obciazenie_id);
        editTrainingReps = findViewById(R.id.powtorzenia_id);

        if(getIntent().hasExtra(EXTRA_EDIT_TRAINING_NAME)){
            String name = getIntent().getStringExtra(EXTRA_EDIT_TRAINING_NAME);
            String load = getIntent().getStringExtra(EXTRA_EDIT_TRAINING_LOAD);
            String reps = getIntent().getStringExtra(EXTRA_EDIT_TRAINING_REPS);
            editTrainingName.setText(name);
            editTrainingLoad.setText(load);
            editTrainingReps.setText(reps);
        }

        final Button button_save = findViewById(R.id.button_save_data);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(editTrainingName.getText()) || TextUtils.isEmpty(editTrainingLoad.getText())
                        || TextUtils.isEmpty(editTrainingReps.getText())){
                    setResult(RESULT_CANCELED,replyIntent);
                } else {
                    replyIntent.putExtra(EXTRA_EDIT_TRAINING_POSITION,getIntent().getIntExtra(EXTRA_EDIT_TRAINING_POSITION,0));
                    String name = editTrainingName.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_TRAINING_NAME,name);

                    String load = editTrainingLoad.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_TRAINING_LOAD,load);

                    String reps = editTrainingReps.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_TRAINING_REPS,reps);

                    setResult(RESULT_OK,replyIntent);
                }
                finish();
            }
        });

    }
}
