package com.example.trainingassistant;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class TrainingItemRepository {

    private TrainingItemDao trainingItemDao;
    private LiveData<List<TrainingItem>> trainingitems;

    public TrainingItemRepository(Application application) {
        MyDatabase database = MyDatabase.getDatabase(application);
        trainingItemDao = database.trainingItemDao();
        trainingitems = trainingItemDao.findAll();
    }

    LiveData<List<TrainingItem>> findAll(){
        return trainingitems;
    }

    void insert(TrainingItem item) {
        MyDatabase.databaseWriteExecutor.execute( () -> {
           trainingItemDao.insert(item);
        });
    }

    void update(TrainingItem item) {
        MyDatabase.databaseWriteExecutor.execute( () -> {
            trainingItemDao.update(item);
        });

    }

    void delete(TrainingItem item) {
        MyDatabase.databaseWriteExecutor.execute( () -> {
            trainingItemDao.delete(item);
        });
    }

    void deleteAll(){
        MyDatabase.databaseWriteExecutor.execute( () -> {
            trainingItemDao.deleteAll();
        });
    }
}
