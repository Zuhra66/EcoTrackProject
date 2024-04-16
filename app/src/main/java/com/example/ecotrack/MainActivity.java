package com.example.ecotrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecotrack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    EditText username;
    EditText password;
    Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Bind the username, password, and sign in button to display
        username = binding.loginIDEditText;
        password = binding.passwordEditText;
        signInButton = binding.signInButton;

        //Checks for sign in info correct
        signInButton.setOnClickListener(v -> {
            if (username.getText().toString().equals("user")
                    && password.getText().toString().equals("1234")){
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Unable to Login", Toast.LENGTH_SHORT).show();
            }
        });

    }
}