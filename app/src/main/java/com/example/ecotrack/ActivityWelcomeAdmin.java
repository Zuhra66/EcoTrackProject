package com.example.ecotrack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecotrack.databinding.ActivityWelcomeAdminBinding;

public class ActivityWelcomeAdmin extends AppCompatActivity {

    private ActivityWelcomeAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}