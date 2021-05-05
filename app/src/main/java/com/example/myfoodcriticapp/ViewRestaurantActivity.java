package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.IDN;

public class ViewRestaurantActivity extends AppCompatActivity {
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();

        long ID = getIntent().getLongExtra("ID",0);
        db = new Database(getApplicationContext());
        Cursor restaurantDetails = db.getRestaurant(ID);
        restaurantDetails.moveToFirst();

        String name =  restaurantDetails.getString(0);
        String address =  restaurantDetails.getString(1);
        String phone = restaurantDetails.getString(2);
        TextView textViewName = findViewById(R.id.restaurantNameViewText);
        TextView textViewAddress = findViewById(R.id.restaurantAddressViewText);
        TextView textViewPhone = findViewById(R.id.restaurantPhoneViewText);
        textViewName.setText(name);
        textViewAddress.setText(address);
        textViewPhone.setText(phone);

        Button editButton = findViewById(R.id.editRestaurantViewBtn);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewRestaurantActivity.this,EditRestaurantActivity.class);
                intent.putExtra("ID",ID);
                startActivity(intent);
            }
        });

    }
}