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
}
