package com.example.trainingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TrainingItemViewModel extends AndroidViewModel {

    private TrainingItemRepository trainingItemRepository;
    private LiveData<List<TrainingItem>> trainingitems;

    public TrainingItemViewModel(@NonNull Application application) {
        super(application);
        trainingItemRepository = new TrainingItemRepository(application);
        trainingitems = trainingItemRepository.findAll();
    }

    public LiveData<List<TrainingItem>> findAll() {return trainingitems;}

    public void insert(TrainingItem item) {
        trainingItemRepository.insert(item);
    }

    public void update(TrainingItem item){
        trainingItemRepository.update(item);
    }

    public void delete(TrainingItem item){
        trainingItemRepository.delete(item);
    }


}
