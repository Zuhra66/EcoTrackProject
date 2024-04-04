package com.example.ecotrack.Database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "eco_track_logs")
public class EcoTrackLog {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Username;
    private int Password;

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

    public EcoTrackLog(String username, int password) {
        Username = username;
        Password = password;
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
