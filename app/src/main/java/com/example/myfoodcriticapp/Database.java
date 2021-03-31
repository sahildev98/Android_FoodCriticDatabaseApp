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
}
