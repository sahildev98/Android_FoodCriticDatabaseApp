package com.example.myfoodcriticapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper (Context context) { super(context, "myFoodCriticDB.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String food_query = "CREATE TABLE IF NOT EXISTS tblFood (" +
                "FoodID int PRIMARY KEY AUTOINCREMENT, "+
                "foodName text,"+
                "price real,"+
                "foodDescription text"+
                ")";
                db.execSQL(food_query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS tblFood");
        onCreate(db);
    }
}
