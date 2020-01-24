package com.example.trainingassistant.Training;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainingassistant.AddNewTraining;
import com.example.trainingassistant.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MyTrainingActivity extends AppCompatActivity {

    private static final int NEW_TRAINING_REQUEST_CODE = 1;
    private TextView TrainingName;
    private RecyclerView recyclerView;
    private ListView ListOfExcercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_training);

        TrainingName = findViewById(R.id.training_name_training_list_item);
        recyclerView = findViewById(R.id.list_of_trainings);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyTrainingActivity.this);
        TrainingAdapter trainingAdapter = new TrainingAdapter(buildTrainingList());
        recyclerView.setAdapter(trainingAdapter);
        recyclerView.setLayoutManager(layoutManager);

        /**
         * Floating button
         */
        FloatingActionButton addButton = findViewById(R.id.floating_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTrainingActivity.this, AddNewTraining.class);
                startActivityForResult(intent, NEW_TRAINING_REQUEST_CODE);
            }
        });
    }

    private List<Training> buildTrainingList(){
        List<Training> trainingList = new ArrayList<>();

        for(int i=0;i<10;i++){
            Training training = new Training("Nazwa Treningu",buildExcerciseList());
            trainingList.add(training);
        }
        return trainingList;
    }

    private List<Excercise> buildExcerciseList() {
        List<Excercise> excerciseList = new ArrayList<>();

        for(int i=0;i<10;i++){
            Excercise excercise = new Excercise("Nazwa ćwiczenia",6);
            excerciseList.add(excercise);
        }
        return excerciseList;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == NEW_TRAINING_REQUEST_CODE) {

            String text = data.getStringExtra(AddNewTraining.EXTRA_TRAINING_NAME);
            TrainingName.setText(text);
            Toast.makeText(MyTrainingActivity.this, "Pomyślnie dodano trening", Toast.LENGTH_LONG).show();

        }
    }
}