package com.example.trainingassistant.Excercises;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ExcerciseViewModel extends AndroidViewModel {

    private ExcerciseRepository excerciseRepository;

    private LiveData<List<Excercise>> ex;

    public ExcerciseViewModel(@NonNull Application application){
        super(application);
        excerciseRepository = new ExcerciseRepository(application);
        ex = excerciseRepository.findAllExcercises();
    }

    public LiveData<List<Excercise>> FindAll(){
        return ex;
    }

    public void insert(Excercise e){
        excerciseRepository.insert(e);
    }

}
