package com.example.ecotrack.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ecotrack.database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert 
    void insertUser(User user);

    @Query("SELECT EXISTS (SELECT * from User where username=:username)")
    boolean is_taken(String username);

    @Query("SELECT EXISTS (SELECT * from User where username=:username " +
            "AND password=:password)")
    boolean login(String username, String password);

    @Query("Select * from  User")
    List<User> getAllRecords();
}
