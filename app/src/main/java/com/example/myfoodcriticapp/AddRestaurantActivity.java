package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.EditText;

public class AddRestaurantActivity extends AppCompatActivity {
EditText restaurant_Name, restaurant_Address, restaurant_Phone;
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

    }
}