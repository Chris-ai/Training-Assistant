package com.example.trainingassistant;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TrainingItem.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract TrainingItemDao trainingItemDao();

    private static volatile MyDatabase INSTANCE;
    public static final int NUMBER_PF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_PF_THREADS);


    static MyDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MyDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,"training_assistant").build();
                }
            }
        }
        return INSTANCE;
    }

}
