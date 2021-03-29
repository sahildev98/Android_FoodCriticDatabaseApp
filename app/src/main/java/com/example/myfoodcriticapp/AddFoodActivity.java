package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

public class AddFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        Long id = getIntent().getLongExtra("ID",0);
        Database db = new Database(getApplicationContext());
        Cursor tblRestaurant = db.outputRestaurantTable();
        tblRestaurant.moveToFirst();




    }
}