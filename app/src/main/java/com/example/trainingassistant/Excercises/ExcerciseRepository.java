package com.example.trainingassistant.Excercises;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ExcerciseRepository {

    private ExcerciseDao exDao;
    private LiveData<List<Excercise>> excercises;

    ExcerciseRepository(Application application){
        ExcerciseDatabase edb = ExcerciseDatabase.getDatabase(application);
        exDao = edb.eDao();
        excercises = exDao.findAll();
    }


    LiveData<List<Excercise>> findAllExcercises(){
        return excercises;
    }

    void insert(Excercise ex){
        ExcerciseDatabase.databaseWriteExecutor.execute( () -> {
            exDao.insert(ex);
        });
    }
}
