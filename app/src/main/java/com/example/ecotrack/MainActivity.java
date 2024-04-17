package com.example.ecotrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecotrack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Error";
    private ActivityMainBinding binding;

    //Global Variables
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
            }
        });

    }

    private void getInformationFromDisplay(){
        //Bind the username, password to display
        username = binding.usernameEditText;
        password = binding.passwordEditText;

        //Checks for sign in info correct
        if (username.getText().toString().equals("user")
                && password.getText().toString().equals("1234")){
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Unable to Login", Toast.LENGTH_SHORT).show();
        }
    }
}