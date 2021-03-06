package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

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
        setContentView(R.layout.activity_add_restaurant);
        long ID = getIntent().getLongExtra("ID",0);
        db = new Database(getApplicationContext());
        Cursor restaurantDetails  = db.getRestaurant(ID);
        restaurantDetails.moveToFirst();

        TextView restaurantNameText = findViewById(R.id.nameTextbox);
        TextView restaurantAddressText = findViewById(R.id.addressTextbox);
        TextView restaurantPhoneText = findViewById(R.id.phoneTextbox);

        restaurantNameText.setText(restaurantDetails.getString(0));
        restaurantAddressText.setText(restaurantDetails.getString(1));
        restaurantPhoneText.setText(restaurantDetails.getString(2));

        Button updateBtn = findViewById(R.id.continueBtn);
        updateBtn.setText(R.string.updateBtnName);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name",restaurantNameText.getText().toString());
                values.put("address",restaurantAddressText.getText().toString());
                values.put("phone",restaurantPhoneText.getText().toString());
                updateRestaurant(values,ID);
                Intent intent = new Intent(EditRestaurantActivity.this, ListRestaurantActivity.class);
                startActivity(intent);
            }
        });
    }
    private void updateRestaurant(ContentValues values, long ID){db.updateRestaurant(values, ID);}
}