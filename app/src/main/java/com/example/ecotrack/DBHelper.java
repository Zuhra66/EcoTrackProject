package com.example.ecotrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);

        return result != -1;
    }

    //Will check if the username exists
    public Boolean checkUsername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?", new String[] {username});

        return cursor.getCount() > 0;
    }

    public Boolean checkUsernamePassword (String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        return cursor.getCount() > 0;
    }
}
