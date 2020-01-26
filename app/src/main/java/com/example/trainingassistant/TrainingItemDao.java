package com.example.trainingassistant;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TrainingItemDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TrainingItem item);

    @Update
    public void update(TrainingItem item);

    @Delete
    public void delete(TrainingItem trainingItem);

    @Query("DELETE FROM trainingitem")
    public void deleteAll();

    @Query("SELECT * FROM trainingitem ORDER BY name")
    public LiveData<List<TrainingItem>> findAll();



}
