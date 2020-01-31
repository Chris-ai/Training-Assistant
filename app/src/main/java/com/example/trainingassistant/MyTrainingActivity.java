package com.example.trainingassistant;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.Preferences;

public class MyTrainingActivity extends AppCompatActivity {

    public static final String USER_TRAININGS_COUNTER = "User_counter";
    public static final String USER_TRAININGS_NOTES = "Notatki_usera";
    public static final String SEND_LAST_NOTES = "Ostatnie notatki";
    public static final String SEND_COUNTER = "Licznik";


    private TrainingItemViewModel trainingItemViewModel;

    public static final int NEW_ITEM_ACTIVITY_REQUEST_CODE = 1;
    public static final int EDIT_ITEM_ACTIVITY_REQUEST_CODE = 2;

    public static final String SHARED_PREFS = "sharedPrefs";

    private TextView notes;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_training);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final TrainingAdapter adapter = new TrainingAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notes = findViewById(R.id.edit_text_training_start);
        loadData();

        trainingItemViewModel = ViewModelProviders.of(this).get(TrainingItemViewModel.class);
        trainingItemViewModel.findAll().observe(this, new Observer<List<TrainingItem>>() {
            @Override
            public void onChanged(List<TrainingItem> trainingItems) {
                adapter.setTrainingItems(trainingItems);
            }
        });

        /**
         * Buttons action
         */
        final Button button_add = findViewById(R.id.floating_button_add_new_series);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent = new Intent(MyTrainingActivity.this,AddNewSeries.class);
                startActivityForResult(MyIntent,NEW_ITEM_ACTIVITY_REQUEST_CODE);
            }
        });

        final Button button_end = findViewById(R.id.end_session);
        button_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                saveData();
                Intent myIntent = new Intent(MyTrainingActivity.this,AboutActivity.class);
                myIntent.putExtra(SEND_COUNTER,getSharedCounter());
                myIntent.putExtra(SEND_LAST_NOTES,getSharedNotes());
                startActivity(myIntent);
                finish();
            }
        });
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


    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(USER_TRAININGS_COUNTER,counter);
        editor.putString(USER_TRAININGS_NOTES,notes.getText().toString());

        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        counter = sharedPreferences.getInt(USER_TRAININGS_COUNTER,0);
       // notes.setText(sharedPreferences.getString(USER_TRAININGS_NOTES, "Brak notatek"));
    }

    private int getSharedCounter(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sharedPreferences.getInt(USER_TRAININGS_COUNTER,0);
    }

    private String getSharedNotes(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        return sharedPreferences.getString(USER_TRAININGS_NOTES,String.valueOf(R.string.No_notes_detected));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_ITEM_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            assert data != null;
            TrainingItem item = new TrainingItem(data.getStringExtra(AddNewSeries.EXTRA_EDIT_TRAINING_NAME)
            ,data.getStringExtra(AddNewSeries.EXTRA_EDIT_TRAINING_LOAD), data.getStringExtra(AddNewSeries.EXTRA_EDIT_TRAINING_REPS));

            String series = data.getStringExtra(AddNewSeries.EXTRA_EDIT_SERIES);
            int check;
            if(series == null){
                check = 1;
            } else { check = Integer.parseInt(series);
            }
             for(int i=0;i<check;i++) {
                 trainingItemViewModel.insert(item);
             }

            Toast.makeText(this, R.string.addedCorrectly,Toast.LENGTH_LONG).show();
        } else if(requestCode == EDIT_ITEM_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            TrainingItem editedItem = trainingItemViewModel.findAll().getValue().get(data.getIntExtra(AddNewSeries.EXTRA_EDIT_TRAINING_POSITION,0));
            editedItem.setName(data.getStringExtra(AddNewSeries.EXTRA_EDIT_TRAINING_NAME));
            editedItem.setLoad(data.getStringExtra(AddNewSeries.EXTRA_EDIT_TRAINING_LOAD));
            editedItem.setReps(data.getStringExtra(AddNewSeries.EXTRA_EDIT_TRAINING_REPS));

            trainingItemViewModel.update(editedItem);
            Toast.makeText(this, R.string.editedCorrectly,Toast.LENGTH_LONG).show();
        } else if( requestCode == EDIT_ITEM_ACTIVITY_REQUEST_CODE && resultCode == RESULT_CANCELED){
            Toast.makeText(getApplicationContext(), R.string.changesNotSaved, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.failed, Toast.LENGTH_LONG).show();
        }
    }

    private class TrainingHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TrainingItem trainingItem;
        private int position;
        private TextView trainingName;
        private TextView trainingLoad;
        private TextView trainingReps;


        public TrainingHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.training_item,parent,false));

            trainingName = itemView.findViewById(R.id.nameofexcercise_rvitem);
            trainingLoad = itemView.findViewById(R.id.how_many_kg_rvitem);
            trainingReps = itemView.findViewById(R.id.how_many_reps_rvitem);

            trainingName.setOnClickListener(this::onClick);
            trainingLoad.setOnClickListener(this::onClick);
            trainingReps.setOnClickListener(this::onClick);

            trainingName.setOnLongClickListener(this::onLongClick);
            trainingLoad.setOnLongClickListener(this::onLongClick);
            trainingReps.setOnLongClickListener(this::onLongClick);
        }

        public void bind(TrainingItem item, int position){
            this.trainingItem = item;
            this.position = position;
            trainingName.setText(trainingItem.getName());
            trainingLoad.setText(trainingItem.getLoad());
            trainingReps.setText(trainingItem.getReps());
        }


        @Override
        public void onClick(View v) {
            Intent editIntent = new Intent(MyTrainingActivity.this, AddNewSeries.class);
            editIntent.putExtra(AddNewSeries.EXTRA_EDIT_TRAINING_NAME,trainingItem.getName());
            editIntent.putExtra(AddNewSeries.EXTRA_EDIT_TRAINING_LOAD,trainingItem.getLoad());
            editIntent.putExtra(AddNewSeries.EXTRA_EDIT_TRAINING_REPS,trainingItem.getReps());
            editIntent.putExtra(AddNewSeries.EXTRA_EDIT_TRAINING_POSITION,position);

            startActivityForResult(editIntent,EDIT_ITEM_ACTIVITY_REQUEST_CODE);
        }

        @Override
        public boolean onLongClick(View v) {
            trainingItemViewModel.delete(trainingItem);
            Toast.makeText(getApplicationContext(), R.string.deleted_correctly,Toast.LENGTH_LONG).show();
            return false;
        }
    }


    private class TrainingAdapter extends RecyclerView.Adapter<TrainingHolder> {

        private List<TrainingItem> trainingItems;

        @NonNull
        @Override
        public TrainingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TrainingHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TrainingHolder holder, int position) {
            if (trainingItems != null) {
                TrainingItem item = trainingItems.get(position);
                holder.bind(item, position);
            } else {
                Log.d("MyTrainingActivity", "NO TRAININGS");
            }
        }

        @Override
        public int getItemCount() {
            if (trainingItems != null) {
                return trainingItems.size();
            } else
                return 0;
        }

        void setTrainingItems(List<TrainingItem> trainingItems) {
            this.trainingItems = trainingItems;
            notifyDataSetChanged();
        }
    }
}
