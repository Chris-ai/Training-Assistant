package com.example.trainingassistant.Training;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingassistant.R;

import java.util.List;

class ExcerciseAdapter extends RecyclerView.Adapter<ExcerciseAdapter.ExcerciseViewHolder> {

   private List<Excercise> excerciseList;

    ExcerciseAdapter(List<Excercise> excerciseList){
        this.excerciseList = excerciseList;
    }

    class ExcerciseViewHolder extends RecyclerView.ViewHolder{
        TextView excerciseName;
        TextView series;
        TextView seriesName;
        View line;

        ExcerciseViewHolder(View item){
            super(item);
            excerciseName = item.findViewById(R.id.excerciseNAME);
            series = item.findViewById(R.id.series_count);
            //seriesName = item.findViewById(R.id.excercise_series);
            line = item.findViewById(R.id.excercise_endline);
        }
    }


    @NonNull
    @Override
    public ExcerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_list_item_excercise,parent,false);
        return new ExcerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExcerciseViewHolder holder, int position) {
        Excercise excercise = excerciseList.get(position);
        holder.excerciseName.setText(excercise.getExcerciseName());
       // holder.seriesName.setText(excercise.getSeriesName());
        holder.series.setText(Integer.toString(excercise.getSeries()));
    }

    @Override
    public int getItemCount() {
        return excerciseList.size();
    }


}
