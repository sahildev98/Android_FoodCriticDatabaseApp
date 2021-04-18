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
import android.widget.Toast;

public class ListRestaurantActivity extends AppCompatActivity {
Button backBtn;
private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);
        // Linear implemented to display all restaurants within a layout
        LinearLayout container = findViewById(R.id.linearContainer);
        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();

        String action = getIntent().getStringExtra("action");
        if(action==null) {
            action = "";
        }

        //  // returns the application object context in order to return data
        db = new Database(getApplicationContext());
        // returns a query that results in displaying all the Restaurants.
        Cursor getRestaurantDetails = db.getAllRestaurants();
        getRestaurantDetails.moveToFirst();



        // backBtn returns back to AddRestaurantActivity
        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListRestaurantActivity.this,AddRestaurantActivity.class);
                startActivity(intent);
            }
        });



    }

}