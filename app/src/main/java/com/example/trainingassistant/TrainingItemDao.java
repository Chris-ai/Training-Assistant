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
    void update(TrainingItem item);

    @Delete
    void delete(TrainingItem trainingItem);

    @Query("DELETE FROM trainingitem")
    void deleteAll();

    @Query("SELECT * FROM trainingitem ORDER BY name")
    LiveData<List<TrainingItem>> findAll();



}
