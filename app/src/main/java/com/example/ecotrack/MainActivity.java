package com.example.ecotrack;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.ecotrack.databinding.ActivityMainBinding;

import Database.AppDatabase;
import Database.EcoTrackDao;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static final String TAG = "malpractice";
    String Username = "";
    int Password = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
            }
        });
    }
    private void getInformationFromDisplay(){
        Username = binding.EnterUsernameInputEditText.getText().toString();
        try {
            Password = Integer.parseInt(binding.EnterPasswordInputEditText.getText().toString());
        }catch (NumberFormatException e){
            Log.d(TAG, "Wrong Password.");
        }
    }
}