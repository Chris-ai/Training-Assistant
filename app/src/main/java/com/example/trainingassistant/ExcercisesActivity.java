package com.example.trainingassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ExcercisesActivity extends AppCompatActivity {


    private Spinner LegsSpinner;
    private Spinner ShouldersSpinner;
    private Spinner ArmsSpinner;
    private Spinner AbsSpinner;
    private Spinner ChestSpinner;
    private Spinner BackSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);

        LegsSpinner = findViewById(R.id.legs_spinner);
        ShouldersSpinner = findViewById(R.id.shoulders_spinner);
        ArmsSpinner = findViewById(R.id.arms_spinner);
        AbsSpinner = findViewById(R.id.abs_spinner);
        ChestSpinner = findViewById(R.id.chest_spinner);
        BackSpinner = findViewById(R.id.back_spinner);

        ArrayList<SpinnerListItem> List = new ArrayList<>();
        List.add(new SpinnerListItem(null,null,null));
        List.add(new SpinnerListItem("Przysiady","Mięsnie czworogłowe i dwugłowe uda", "Cwiczenie wykonujemy najlepiej z normalną szatangą, kładziemy ją na plecach i w powolnym przysiadzie próbujemy unieść ciężar całej sztangi"));
        List.add(new SpinnerListItem("Przysiady","Mięsnie czworogłowe i dwugłowe uda", "Cwiczenie wykonujemy najlepiej z normalną szatangą, kładziemy ją na plecach i w powolnym przysiadzie próbujemy unieść ciężar całej sztangi"));
        List.add(new SpinnerListItem("Przysiady","Mięsnie czworogłowe i dwugłowe uda", "Cwiczenie wykonujemy najlepiej z normalną szatangą, kładziemy ją na plecach i w powolnym przysiadzie próbujemy unieść ciężar całej sztangi"));
        List.add(new SpinnerListItem("Przysiady","Mięsnie czworogłowe i dwugłowe uda", "Cwiczenie wykonujemy najlepiej z normalną szatangą, kładziemy ją na plecach i w powolnym przysiadzie próbujemy unieść ciężar całej sztangi"));
        List.add(new SpinnerListItem("Przysiady","Mięsnie czworogłowe i dwugłowe uda", "Cwiczenie wykonujemy najlepiej z normalną szatangą, kładziemy ją na plecach i w powolnym przysiadzie próbujemy unieść ciężar całej sztangi"));
        List.add(new SpinnerListItem("Przysiady","Mięsnie czworogłowe i dwugłowe uda", "Cwiczenie wykonujemy najlepiej z normalną szatangą, kładziemy ją na plecach i w powolnym przysiadzie próbujemy unieść ciężar całej sztangi"));
        List.add(new SpinnerListItem("Przysiady","Mięsnie czworogłowe i dwugłowe uda", "Cwiczenie wykonujemy najlepiej z normalną szatangą, kładziemy ją na plecach i w powolnym przysiadzie próbujemy unieść ciężar całej sztangi"));


        SpinnerAdapter adapter = new SpinnerAdapter(this, List);

        if(LegsSpinner != null){
            LegsSpinner.setAdapter(adapter);
        }

        if(ShouldersSpinner != null){
            ShouldersSpinner.setAdapter(adapter);
        }

        if(ArmsSpinner != null){
            ArmsSpinner.setAdapter(adapter);
        }

        if(ChestSpinner != null){
            ChestSpinner.setAdapter(adapter);
        }

        if(AbsSpinner != null){
            AbsSpinner.setAdapter(adapter);
        }

        if(BackSpinner != null){
            BackSpinner.setAdapter(adapter);
        }
    }
}

