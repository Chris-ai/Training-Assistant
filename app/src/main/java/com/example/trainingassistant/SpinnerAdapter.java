package com.example.trainingassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SpinnerAdapter extends ArrayAdapter<SpinnerListItem>{

    public SpinnerAdapter(@NonNull Context context, ArrayList<SpinnerListItem> list){
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }


    public View customView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.simple_spinner_layout, parent, false);

        }

        SpinnerListItem items = getItem(position);
        TextView spinnerName = convertView.findViewById(R.id.excercise_name_in_spinner);
        TextView spinnerMuscle = convertView.findViewById(R.id.which_muscle_parts);
        TextView spinnerDesc = convertView.findViewById(R.id.desctripction);

        if(items != null){
            spinnerName.setText(items.getSpinnerText());
            spinnerMuscle.setText(items.getSpinnerMuscleParts());
            spinnerDesc.setText(items.getSpinnerDescription());
        }

        return convertView;
    }

}
