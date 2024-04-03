package com.example.ecotrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import Database.AppDatabase;
import Database.EcoTrackDao;

public class MainActivity extends AppCompatActivity {

    TextView MainDisplay;
    EditText Username;
    EditText Password;
    Button SignIn;
    TextView New_User;
    Button SignUp;
    EcoTrackDao EcoTrackDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainDisplay = findViewById(R.id.Please_Sign_In);
        Username = findViewById(R.id.Enter_Username);
        Password = findViewById(R.id.Enter_Password);
        SignIn = findViewById(R.id.Sign_In);
        New_User = findViewById(R.id.New_user_message);
        SignUp = findViewById(R.id.Sign_Up);

        Database.EcoTrackDao = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .EcoTrackDao;


    }
}