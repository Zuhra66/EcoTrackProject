package com.example.ecotrack.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import com.example.ecotrack.database.entities.EcoTrackLog;


@Dao
public interface EcoTrackLogDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EcoTrackLog ecoTrackLog);
    @Query("Select * from " +EcoTrackDatabase.ECOTRACK_LOG_TABLE)
    List<EcoTrackLog> getAllRecords();

}
