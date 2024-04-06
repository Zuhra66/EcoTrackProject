package com.example.ecotrack.database.entities;

import android.os.Build;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.ecotrack.database.EcoTrackDatabase;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(tableName = EcoTrackDatabase.ECOTRACK_LOG_TABLE)
public class EcoTrackLog {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Username;
    private int Password;
    private LocalDateTime date;
    public EcoTrackLog() {
    }
    public EcoTrackLog(String username, int password) {
        this.Username = username;
        this.Password = password;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EcoTrackLog that = (EcoTrackLog) o;
        return id == that.id && Password == that.Password && Objects.equals(Username, that.Username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Username, Password);
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}
