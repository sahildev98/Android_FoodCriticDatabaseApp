package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditRestaurantActivity extends AppCompatActivity {
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_restaurant);
        Long ID = getIntent().getLongExtra("ID",0);
        db = new Database(getApplicationContext());
        Cursor restaurantDetails  = db.getRestaurant(ID);
        restaurantDetails.moveToFirst();

        TextView restaurantNameText = findViewById(R.id.nameTextbox);
        TextView restaurantAddressText = findViewById(R.id.addressTextbox);
        TextView restaurantPhoneText = findViewById(R.id.phoneTextbox);

    }
}