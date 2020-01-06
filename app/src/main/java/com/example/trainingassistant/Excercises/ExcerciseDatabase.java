package com.example.trainingassistant.Excercises;

import android.content.Context;
import android.support.v4.app.INotificationSideChannel;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities = {Excercise.class}, version = 1, exportSchema = false)
public abstract class ExcerciseDatabase extends RoomDatabase {

    public abstract ExcerciseDao eDao();

    private static volatile ExcerciseDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ExcerciseDatabase getDatabase(final Context context){
        if(INSTANCE == null){

            synchronized (ExcerciseDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ExcerciseDatabase.class,"excercise_db")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }

        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
                super.onOpen(db);
                databaseWriteExecutor.execute( () -> {

                    Excercise ex1 = new Excercise("Barki","Wyciskanie sztangi sprzed głowy", "Przednie i boczne aktony", "Ćwiczenie można wykonywać zarówno w pozycji stojącej jak i siedzącej. Do ćwiczenia można użyć maszyn. Unosimy sztangę poonad głowę i powracamy.");

                });
        }

    };


}
