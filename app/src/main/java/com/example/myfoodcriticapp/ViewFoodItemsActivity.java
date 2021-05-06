package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewFoodItemsActivity extends AppCompatActivity {
private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_items);
        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class, null);
        fragmentTransact.commit();
        // returns the application object context in order to return data
        long foodID = getIntent().getLongExtra("restaurantID", 0);
        db = new Database(getApplicationContext());
        Cursor foodDetails = db.getFood(foodID);

        String foodName = foodDetails.getString(0);
        String foodPrice = foodDetails.getString(1);
        String foodDescription = foodDetails.getString(2);
        TextView textViewFoodName = findViewById(R.id.foodNameText);
        TextView textViewPrice = findViewById(R.id.foodPriceText);
        TextView textViewDescription = findViewById(R.id.foodDescriptionText);
        textViewFoodName.setText(foodName);
        textViewPrice.setText(foodPrice);
        textViewDescription.setText(foodDescription);

        Button editBtn = findViewById(R.id.foodEditBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewFoodItemsActivity.this,EditRestaurantActivity.class);
                startActivity(intent);
            }
        });

        Button nxtAddReviewButton = findViewById(R.id.nxtReviewBtn);
        nxtAddReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}