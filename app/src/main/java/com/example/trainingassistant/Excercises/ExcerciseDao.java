package com.example.trainingassistant.Excercises;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExcerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Excercise ex);


    @Update
    public void update(Excercise ex);

    @Delete
    public void delete(Excercise ex);

    @Query("DELETE FROM Excercise")
    public void DeleteAll();

    @Query("SELECT * FROM Excercise WHERE type LIKE:type")
    public List<Excercise> findExcerciseWithType(String type);

    @Query("SELECT * FROM Excercise ORDER BY name")
    public LiveData<List<Excercise>> findAll();


}
