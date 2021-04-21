package com.example.myfoodcriticapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Database extends DatabaseHelper {
    public Database(Context context) {
        super(context);
    }

    public long addRestaurant(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("restaurant", null, values);
    }

    public long addFood(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("food", null, values);
    }

    public long addReview(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("ratings",null,values);
    }

    public long updateRestaurant(ContentValues values, long ID, String newValue) {
        SQLiteDatabase db = getWritableDatabase();

        return 1;
    }

    public Cursor getRestaurant(long ID) {
        SQLiteDatabase db  = this.getReadableDatabase();
        String table = "Restaurant";
        String [] columns = {"name", "address", "phone", "ID"};
        String selection = "ID=?";
        String  [] selectionArgs = {String.valueOf(ID)};
        String groupBy = null;
        String having = null;
        String orderBy = "name DESC";
        String limit = "";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        return cursor;

    }

    public Cursor getAllRestaurants() {
        SQLiteDatabase db  = this.getReadableDatabase();
        String table = "Restaurant";
        String [] columns = {"name", "address", "phone", "ID"};
        String selection = "";
        String  [] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "name DESC";
        String limit = "";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        return cursor;

    }

    public Cursor getMenuItems(long restaurantID){
        SQLiteDatabase db  = this.getReadableDatabase();
        String table = "Food";
        String [] columns = {"name", "price", "description", "ID"};
        String selection = "restaurantID=?";
        String [] selectionsArgs = {String.valueOf(restaurantID)};
        String groupBy = null;
        String having = null;
        String orderBy = "name DESC";
        String limit = "";

        Cursor cursor = db.query(table, columns, selection, selectionsArgs, groupBy, having, orderBy, limit);
        return cursor;
    }


    public Cursor getFood(long ID){
        SQLiteDatabase db  = this.getReadableDatabase();
        String table = "Food";
        String [] columns = {"name", "price", "description", "ID"};
        String selection = "ID=?";
        String [] selectionsArgs = {String.valueOf(ID)};
        String groupBy = null;
        String having = null;
        String orderBy = "name DESC";
        String limit = "";

        Cursor cursor = db.query(table, columns, selection, selectionsArgs, groupBy, having, orderBy, limit);
        return cursor;
    }


    public Cursor outputRestaurantTable() {
        SQLiteDatabase db  = this.getReadableDatabase();
        String table = "Restaurant";
        String [] columns = {"name", "address", "phone"};
        String selection = "";
        String  [] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "name DESC";
        String limit = "100";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        return cursor;
    }

    public Cursor outputFoodTable(){
        SQLiteDatabase db = this.getReadableDatabase();
        String table = "Food";
        String [] columns = {"name", "price", "description"};
        String selection = "";
        String [] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "name DESC";
        String limit = "100";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        return cursor;
    }

    public int deleteRestaurant(long ID){
        SQLiteDatabase db = this.getWritableDatabase();
        String column = "ID=?";
        String [] restaurant =  {String.valueOf(ID)};

        return db.delete("Restaurant", column,restaurant);
    }
}
