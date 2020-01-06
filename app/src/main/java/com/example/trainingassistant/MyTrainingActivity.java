package com.example.trainingassistant;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MyTrainingActivity extends AppCompatActivity {

    private static final int NEW_TRAINING_REQUEST_CODE = 1;
    private TextView TrainingName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_training);

        TrainingName = findViewById(R.id.training_name_training_list_item);

        RecyclerView recyclerView = findViewById(R.id.list_of_trainings);
        final RecycleAdapter adapter = new RecycleAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton addButton = findViewById(R.id.floating_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTrainingActivity.this, AddNewTraining.class);
                startActivityForResult(intent,NEW_TRAINING_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == NEW_TRAINING_REQUEST_CODE){

            String text = data.getStringExtra(AddNewTraining.EXTRA_TRAINING_NAME);
            TrainingName.setText(text);
            Toast.makeText(MyTrainingActivity.this,"Pomyślnie dodano trening",Toast.LENGTH_LONG).show();

        }
    }

    private class RecycleHolder extends RecyclerView.ViewHolder{
        private TextView training_name;
        private RecyclerView list_of_ex;

        public RecycleHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.training_list_item, parent,false));

            training_name = itemView.findViewById(R.id.training_name_training_list_item);
            list_of_ex = itemView.findViewById(R.id.excercises_in_trainings);
        }

    }

    private class RecycleAdapter extends RecyclerView.Adapter<RecycleHolder>{

        @NonNull
        @Override
        public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RecycleHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecycleHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
