package com.example.trainingassistant.Training;


import android.view.View;

public class Excercise {

    private String ExcerciseName;
    private int series;
    //private String seriesName;


    public Excercise(String name, int series) {//String seriesName){
        ExcerciseName = name;
        this.series = series;
        //this.seriesName = seriesName;
    }

    public String getExcerciseName() {
        return ExcerciseName;
    }

    public void setExcerciseName(String excerciseName) {
        ExcerciseName = excerciseName;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
/*
    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }*/

}
