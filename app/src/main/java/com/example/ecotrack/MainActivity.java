package com.example.ecotrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.ecotrack.database.UserDAO;
import com.example.ecotrack.database.UserDatabase;
import com.example.ecotrack.database.UserRepository;
import com.example.ecotrack.database.entities.User;
import com.example.ecotrack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Error";
    private ActivityMainBinding binding;
    //private UserRepository repository;

    //Global Variables
    String username;
    String password;
    UserDatabase myDB;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myDB = Room.databaseBuilder(this, UserDatabase.class, "user")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        userDAO = myDB.userDAO();

        //Have not implemented repository
        //TODO: repository = new UserRepository(getApplication());

        //Enabling user to Login if account information matches
        binding.signInButton.setOnClickListener(v -> {
            getInformationFromDisplay();
            //checks in database for the account that matches
            if (userDAO.login(username, password)){
                startActivity(new Intent(MainActivity.this, EcoTrackDashboard.class));
            } else {
                Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
        });

        //Enables user to register for new account
       binding.signUpButton.setOnClickListener(v -> {
           startActivity(new Intent(MainActivity.this, SignUpActivity.class));
       });

    }

    private void getInformationFromDisplay(){
        //Bind the username, password to display
        username = binding.usernameEditText.getText().toString();
        password = binding.passwordEditText.getText().toString();
    }
}