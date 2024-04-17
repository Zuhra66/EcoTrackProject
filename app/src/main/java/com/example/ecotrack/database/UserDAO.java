package com.example.ecotrack.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ecotrack.database.entities.User;
import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);
    @Query("SELECT * FROM " + UserDatabase.USER_TABLE)
    List<User> getAllUsers();

    @Query("Select * from " + UserDatabase.USER_TABLE)
    List<User> getAllRecords();
}
