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

public class ListRestaurantActivity extends AppCompatActivity {
Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);
        LinearLayout container = findViewById(R.id.linearContainer);
        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();

        Database db = new Database(getApplicationContext());
        Cursor getRestaurantDetails = db.getAllRestaurants();
        getRestaurantDetails.moveToFirst();

        do {
            String getRestaurantName = getRestaurantDetails.getString(0);
            TextView restaurantName = new TextView(this);
            restaurantName.setText(getRestaurantName);
            container.addView(restaurantName);
            Button deleteBtn = new Button(this);
            deleteBtn.setText("Delete");
            container.addView(deleteBtn);
        } while(getRestaurantDetails.moveToNext());

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