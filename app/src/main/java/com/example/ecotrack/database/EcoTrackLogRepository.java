package com.example.ecotrack.database;

import android.app.Application;
import android.util.Log;

import com.example.ecotrack.MainActivity;
import com.example.ecotrack.database.EcoTrackDatabase;
import com.example.ecotrack.database.EcoTrackLogDAO;
import com.example.ecotrack.database.entities.EcoTrackLog;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EcoTrackLogRepository{
    private EcoTrackLogDAO ecoTrackLogDAO;
    private ArrayList<EcoTrackLog> allLogs;

    public EcoTrackLogRepository(Application application) {
        EcoTrackDatabase db = EcoTrackDatabase.getDatabase(application);
        this.ecoTrackLogDAO = db.ecoTrackLogDAO();
        this.allLogs = new ArrayList<>();
        getAllLogsFromDatabase();
    }

    private void getAllLogsFromDatabase() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<ArrayList<EcoTrackLog>> future = executorService.submit(new Callable<ArrayList<EcoTrackLog>>() {
            @Override
            public ArrayList<EcoTrackLog> call() throws Exception {
                return (ArrayList<EcoTrackLog>) ecoTrackLogDAO.getAllRecords();
            }
        });

        try {
            allLogs = future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(MainActivity.TAG, "Problem when getting all EcoTrackLog in the repository");
        }

        executorService.shutdown();
    }

    public ArrayList<EcoTrackLog> getAllLogs() {
        return allLogs;
    }

    public void insertEcoTrackLog(EcoTrackLog ecoTrackLog) {
        EcoTrackDatabase.databaseWriteExecutor.execute(() -> {
            ecoTrackLogDAO.insert(ecoTrackLog);
        });
    }
}