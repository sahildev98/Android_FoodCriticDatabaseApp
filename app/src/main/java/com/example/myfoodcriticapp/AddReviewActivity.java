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
import android.widget.RatingBar;
import android.widget.TextView;

public class AddReviewActivity extends AppCompatActivity {
EditText reviewDescription;
RatingBar simpleRatingBar;
Button addCritBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();
        /**
         * retrieves intent data from from previous activity. This foodID represents as a foreign key to the
         * table food.
         */
        Long foodID = getIntent().getLongExtra("ID",0);
        Database db = new Database(getApplicationContext());
        Cursor foodDetails = db.getFood(foodID);
        foodDetails.moveToFirst();
        String storeFoodName = "Food name entered " + foodDetails.getString(0);

        // The Following food name, rating bar, review description and add Critic btn are initialised with their corresponding ids in activity add review xml.
        TextView foodNameValue = findViewById(R.id.foodName);
        foodNameValue.setText(storeFoodName);
        reviewDescription = findViewById(R.id.reviewEditText);
        simpleRatingBar = findViewById(R.id.ratingBar);
        addCritBtn = findViewById(R.id.addReviewBtn);

        addCritBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Values that will be inserted into the database with the following columns: rating
            and review. Review parsed in as String and rating parsed in as int.  */
                int ratingValue = simpleRatingBar.getNumStars();
                String reviewValue = reviewDescription.getText().toString();
                // ContentValues class is implemented for containing the data above so it that can be passed onto.
                ContentValues values = new ContentValues();
                values.put("foodID", foodID);
                values.put("ratings", ratingValue);
                values.put("review", reviewValue);
                Intent intent = new Intent(AddReviewActivity.this,OutputFoodCrticActivity.class);
                startActivity(intent);
            }
        });


    }
}