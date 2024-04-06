package com.example.ecotrack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecotrack.databinding.ActivityWelcomeUserBinding;

public class ActivityWelcomeUser extends AppCompatActivity {

    private ActivityWelcomeUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}