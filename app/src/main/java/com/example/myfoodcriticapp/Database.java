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
        return db.insert("tblRestaurant", null, values);
    }

    public Cursor outputRestaurantTable() {
        SQLiteDatabase db  = this.getWritableDatabase();
        String table = "tblRestaurant";
        String [] columns = {"restaurantName", "address, phoneNum"};
        String selection = "";
        String  [] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "restaurantName DESC";
        String limit = "100";

        Cursor cursor = db.query(table,columns,selection,selectionArgs,groupBy,having,orderBy,limit);
        return cursor;
    }
}
