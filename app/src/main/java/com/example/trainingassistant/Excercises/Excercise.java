package com.example.trainingassistant.Excercises;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Excercise")
public class Excercise {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String type;
    private String name;
    private String muscle;
    private String description;


    public Excercise(String type, String name, String muscle, String description){
        this.name = name;
        this.type = type;
        this.muscle = muscle;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
