package com.example.ecotrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.ecotrack.database.UserDAO;
import com.example.ecotrack.database.UserDatabase;
import com.example.ecotrack.databinding.ActivityEcoTrackDashboardBinding;
import com.example.ecotrack.database.entities.User;

public class EcoTrackDashboard extends AppCompatActivity {
    private ActivityEcoTrackDashboardBinding binding;
    UserDAO userDAO;
    UserDatabase myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEcoTrackDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myDB = Room.databaseBuilder(this, UserDatabase.class, "user")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        userDAO = myDB.userDAO();

        binding.carbonFootprintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EcoTrackDashboard.this, "It works!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcoTrackDashboard.this, MainActivity.class));
            }
        });

    }
}