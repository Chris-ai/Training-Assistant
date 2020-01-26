package com.example.trainingassistant;

import androidx.core.content.PermissionChecker;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trainingitem")
public class TrainingItem {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String load;
    private String reps;


    public TrainingItem(String name, String load, String reps){
        this.name = name;
        this.load = load;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
