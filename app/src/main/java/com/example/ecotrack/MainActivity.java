package com.example.ecotrack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecotrack.database.EcoTrackLogRepository;
import com.example.ecotrack.database.entities.EcoTrackLog;
import com.example.ecotrack.databinding.ActivityMainBinding;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EcoTrackLogRepository repository;
    private Button SignUpButton;
    public static final String TAG = "malpractice";
    String Username = "";
    int Password = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        repository = new EcoTrackLogRepository(getApplication());
        binding.SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                insertEcoTrackLogRecord();
            }
        });
    }

    private void insertEcoTrackLogRecord() {
        EcoTrackLog log = new EcoTrackLog(Username, Password);
        repository.insertEcoTrackLog(log);
    }

    private void getInformationFromDisplay() {
        Username = binding.EnterUsernameInputEditText.getText().toString();
        try {
            Password = Integer.parseInt(binding.EnterPasswordInputEditText.getText().toString());
        } catch (NumberFormatException e) {
            Log.d(TAG, "Wrong Password.");
        }
    }
}