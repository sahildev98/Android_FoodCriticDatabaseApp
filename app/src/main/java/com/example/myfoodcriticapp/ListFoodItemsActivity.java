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

public class ListFoodItemsActivity extends AppCompatActivity {
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food_items);
        LinearLayout container = findViewById(R.id.linearContainer);

        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();

        //  // returns the application object context in order to return data
        db = new Database(getApplicationContext());
        long foodID = getIntent().getLongExtra("restaurantID", 0);
        Cursor getFoodItemsDetails = db.getMenuItems(foodID);
        getFoodItemsDetails.moveToFirst();
        do {
            String foodName = getFoodItemsDetails.getString(0);
            TextView foodNameText = new TextView(this);
            foodNameText.setText(foodName);
            container.addView(foodNameText);
            Button viewRestaurantBtn = new Button(this);
            long restaurantID = getFoodItemsDetails.getLong(3);
            viewRestaurantBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ListFoodItemsActivity.this,ViewFoodItemsActivity.class);
                    intent.putExtra("restaurantID", restaurantID);
                    startActivity(intent);
                }
            });
            viewRestaurantBtn.setText("View");
            container.addView(viewRestaurantBtn);
        }while (getFoodItemsDetails.moveToNext());

        Button backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}