package com.example.myfoodcriticapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper (Context context) { super(context, "myFoodCriticDB.db", null, 3); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String restaurant_Query = "CREATE TABLE IF NOT EXISTS Restaurant (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                "name text,"+
                "address text,"+
                "phone text"+
                ")";
                db.execSQL(restaurant_Query);

        String food_Query = "CREATE TABLE IF NOT EXISTS Food (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                "restaurantID int,"+
                "name text,"+
                "price real,"+
                "description text,"+
                "FOREIGN KEY (RestaurantID) REFERENCES restaurant(ID)"+
                ")";
                db.execSQL(food_Query);


        String ratings_Query = "CREATE TABLE IF NOT EXISTS Ratings (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                "foodID int,"+
                "ratings numeric,"+
                "review text,"+
                "FOREIGN KEY (foodID) REFERENCES Food(ID)"+
                ")";
                db.execSQL(ratings_Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS Restaurant");
        db.execSQL("Drop TABLE IF EXISTS Food");
        db.execSQL("Drop TABLE IF EXISTS Ratings");
        onCreate(db);
    }
}
