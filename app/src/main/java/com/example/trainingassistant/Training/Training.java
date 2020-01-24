package com.example.trainingassistant.Training;

import java.util.List;

public class Training {

    private String TrainingName;
    private List<Excercise> excercisesInTraining;


    public Training(String name, List<Excercise> excercises){
        TrainingName = name;
        excercisesInTraining = excercises;
    }

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public List<Excercise> getExcercisesInTraining() {
        return excercisesInTraining;
    }

    public void setExcercisesInTraining(List<Excercise> excercisesInTraining) {
        this.excercisesInTraining = excercisesInTraining;
    }
}
