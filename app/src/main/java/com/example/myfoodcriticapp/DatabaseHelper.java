package com.example.myfoodcriticapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper (Context context) { super(context, "myFoodCriticDB.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String restaurant_Query = "CREATE TABLE IF NOT EXISTS tblRestaurant (" +
                "RestaurantID int PRIMARY KEY AUTOINCREMENT,"+
                "restaurantName text,"+
                "address text,"+
                "phoneNum int"+
                ")";
                db.execSQL(restaurant_Query);

        String food_Query = "CREATE TABLE IF NOT EXISTS tblFood (" +
                "FoodID int PRIMARY KEY AUTOINCREMENT, "+
                "PlaceID int,"+
                "foodName text,"+
                "price real,"+
                "FOREIGN KEY (PlaceID) REFERENCES PlaceID(RestaurantID)"+
                ")";
                db.execSQL(food_Query);


        String ratings_query = "CREATE TABLE IF NOT EXISTS tblRatings (" +
                "RatingsID int PRIMARY KEY AUTOINCREMENT,"+
                "locationID int,"+
                "Ratings numeric,"+
                "food_description text,"+
                "FOREIGN KEY (LocationID) REFERENCES LocationID(RestaurantID)"+
                ")";
                db.execSQL(ratings_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS tblRestaurant");
        onCreate(db);
        db.execSQL("Drop TABLE IF EXISTS tblFood");
        onCreate(db);
        db.execSQL("Drop TABLE IF EXISTS tblRatings");
    }
}
