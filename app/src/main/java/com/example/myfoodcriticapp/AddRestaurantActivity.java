package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRestaurantActivity extends AppCompatActivity {
EditText restaurant_Name, restaurant_Address, restaurant_Phone;
Button continue_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();

        restaurant_Name = findViewById(R.id.restaurant_Textbox);
        restaurant_Address = findViewById(R.id.address_Textbox);
        restaurant_Phone = findViewById(R.id.phone_Textbox);
        continue_btn = findViewById(R.id.continue_Btn);

        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /* Values that will be inserted in to the database with String Restaurant name
            address and phone number. */
                String restaurantNameValue = restaurant_Name.getText().toString();
                String restaurantAddressValue = restaurant_Address.getText().toString();
                String restaurantPhoneNumValue = restaurant_Phone.getText().toString();
                ContentValues values = new ContentValues();
                values.put("name", restaurantNameValue);
                values.put("address", restaurantAddressValue);
                values.put("phone", restaurantPhoneNumValue);



            }

        });

    }
}