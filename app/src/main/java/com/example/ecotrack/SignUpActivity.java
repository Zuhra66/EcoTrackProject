package com.example.ecotrack;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.ecotrack.database.UserDAO;
import com.example.ecotrack.database.UserDatabase;
import com.example.ecotrack.databinding.ActivitySignUpBinding;
import com.example.ecotrack.database.entities.User;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    UserDAO userDAO;
    UserDatabase myDB;
    public static boolean isAllowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        myDB = Room.databaseBuilder(this, UserDatabase.class, "user")
                        .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        userDAO = myDB.userDAO();

        binding.newUsernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String userName = editable.toString();
                if (userDAO.is_taken(userName)){
                    isAllowed = false;
                } else {
                    isAllowed = true;
                }
            }
        });

        binding.registerButton.setOnClickListener(v -> {
            String username = binding.newUsernameEditText.getText().toString();
            String password = binding.newPasswordEditText.getText().toString();
            String retypePassword = binding.newRetypePasswordEditText.getText().toString();

            //isAllowed checks that username is not already in use
            if (isAllowed){

                //Checks for passwords to match and creates Account
                //Keeps waiting until passwords match
                if (password.equals(retypePassword)){
                    userDAO.insertUser(new User(username, password));
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(SignUpActivity.this, "Password do not match! Please try again.", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(SignUpActivity.this, "Username is already taken!", Toast.LENGTH_SHORT).show();
            }


        });
    }
}