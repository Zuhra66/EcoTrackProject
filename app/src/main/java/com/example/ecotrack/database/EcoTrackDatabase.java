package com.example.ecotrack.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ecotrack.database.entities.EcoTrackLog;
import com.example.ecotrack.MainActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {EcoTrackLog.class}, version = 1, exportSchema = false)
@TypeConverters(LocalDateTimeConverter.class)
public abstract class EcoTrackDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "Ecotrack_database";
    public static final String ECOTRACK_LOG_TABLE = "ecoTrackLogTable";
    private static EcoTrackDatabase INSTANCE;

    public static final int NUMBER_OF_THREADS = 2;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static EcoTrackDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EcoTrackDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    EcoTrackDatabase.class,
                                    DATABASE_NAME)
                            .addCallback(addDefaultValues)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.i(MainActivity.TAG, "Database created! ");

        }
    };

    public abstract EcoTrackLogDAO ecoTrackLogDAO();
}