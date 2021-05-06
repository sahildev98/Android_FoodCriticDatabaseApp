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
import android.widget.TextView;
import android.widget.Toast;

public class AddFoodActivity extends AppCompatActivity {
    EditText foodName, price, foodDescription;
    Button addFoodBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class, null);
        fragmentTransact.commit();
        /**
         * retrieves intent data from from previous activity. Restaurant ID represents as a foreign key to the
         * table restaurant ID
         */
        Long restaurantID = getIntent().getLongExtra("ID", 0);
        // returns the application object context in order to return data
        Database db = new Database(getApplicationContext());
        Cursor restaurantDetails = db.getRestaurant(restaurantID);
        restaurantDetails.moveToFirst();
        String restaurantName = "Restaurant name entered: " + restaurantDetails.getString(0);
        String restaurantAddress = restaurantDetails.getString(1);
        String restaurantPhone = restaurantDetails.getString(2);
        // The following EditText views and a button are initialised to the corresponding ids set in activity_add_food xml.

        TextView restaurantNameTextView = findViewById(R.id.restaurantNameText);
        restaurantNameTextView.setText(restaurantName);
        foodName = findViewById(R.id.foodTextbox);
        price = findViewById(R.id.priceTextbox);
        foodDescription = findViewById(R.id.descriptionTextbox);
        addFoodBtn = findViewById(R.id.addFoodItemBtn);

        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Values that will be inserted into the database with the following columns: name
            price and description passed in as Strings and double for price.  */
                String foodNameValue = foodName.getText().toString();
                String priceString = price.getText().toString();
                double priceValue = Double.parseDouble(priceString);
                String descriptionValue = foodDescription.getText().toString();
                // ContentValues class is implemented for containing the data above so it that can be passed onto.
                ContentValues values = new ContentValues();
                values.put("restaurantID", restaurantID);
                values.put("name", foodNameValue);
                values.put("price", priceValue);
                values.put("description", descriptionValue);
                /* Calls the addFood() method in database class and save data.
                    Long instance is created
                    to parse the primary key to the next activity as a foreign key use.
                    The startActivity occurs to to initiate the next activity called AddReviewActivity.
                 */

                if (foodNameValue.isEmpty() || priceString.isEmpty() || descriptionValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Food Details Again!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Successfully Entered Food Item.", Toast.LENGTH_LONG).show();
                    long foodID = db.addFood(values);
                }
            }
        });
    }
}