package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ViewFoodItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_items);

        //        Button nxtAddReviewButton = findViewById(R.id.nxtReviewBtn);
//        nxtAddReviewButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ViewRestaurantActivity.this, AddReviewActivity.class);
//                intent.putExtra("ID",ID);
//                startActivity(intent);
//            }
//        });
    }
}