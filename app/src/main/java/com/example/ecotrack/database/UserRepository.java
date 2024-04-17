package com.example.ecotrack.database;

import android.app.Application;
import android.util.Log;

import com.example.ecotrack.database.entities.User;
import com.example.ecotrack.MainActivity;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UserRepository {

    private UserDAO userDAO;
    private ArrayList<User> allUsers;

    public UserRepository(Application application){
        UserDatabase db = UserDatabase.getDatabase(application);
        this.userDAO = db.userDAO();
        this.allUsers = (ArrayList<User>) this.userDAO.getAllRecords();
    }

    public ArrayList<User> getAllUsers() {
        Future<ArrayList<User>> future = UserDatabase.databaseWriteExecutor.submit(
                new Callable<ArrayList<User>>() {
                    @Override
                    public ArrayList<User> call() throws Exception {
                        return (ArrayList<User>) userDAO.getAllRecords();
                    }
                }
        );
        try{
            return future.get();
        } catch(InterruptedException | ExecutionException e){
            Log.i(MainActivity.TAG, "Problem when getting all Users in the repository");
        }
        return null;
    }

    public void insertUser(User user) {
        UserDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.insert(user);
        });
    }
}
