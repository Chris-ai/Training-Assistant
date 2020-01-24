package com.example.trainingassistant.Training;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingassistant.R;

import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {


    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<Training> trainingList;

    TrainingAdapter(List<Training> trainingList){
        this.trainingList = trainingList;
    }


    class TrainingViewHolder extends RecyclerView.ViewHolder{
        private TextView TrainingNameTextView;
        private RecyclerView Excercises;


        TrainingViewHolder(View item){
            super(item);
            TrainingNameTextView = item.findViewById(R.id.training_name_training_list_item);
            Excercises = item.findViewById(R.id.excercises_in_trainings);
        }
    }


    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_list_item,parent,false);
        return new TrainingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        Training training = trainingList.get(position);
        holder.TrainingNameTextView.setText(training.getTrainingName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.Excercises.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(training.getExcercisesInTraining().size());


        //Tworzenie adaptera dla ćwiczeń(podlisty)
        ExcerciseAdapter excerciseAdapter = new ExcerciseAdapter(training.getExcercisesInTraining());

        holder.Excercises.setLayoutManager(layoutManager);
        holder.Excercises.setAdapter(excerciseAdapter);
        holder.Excercises.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return trainingList.size();
    }
}

