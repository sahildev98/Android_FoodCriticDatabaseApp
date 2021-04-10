package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFoodActivity extends AppCompatActivity {
EditText foodName, price, foodDescription;
Button continueBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();
        /**
         * retrieves intent data from from previous activity. This ID represents as a foreign key to the
         * table restaurant ID
         */
        Long id = getIntent().getLongExtra("ID",0);
        Database db = new Database(getApplicationContext());
        // The following EditText views and a button are initialised to the corresponding ids set in activity_add_food xml.
        foodName = findViewById(R.id.foodTextbox);
        price = findViewById(R.id.priceTextbox);
        foodDescription = findViewById(R.id.descriptionTextbox);
        continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Values that will be inserted into the database with the following columns: name
            price and description passed in as Strings and double for price.  */
                String foodNameValue = foodName.getText().toString();
                String priceString =  price.getText().toString();
                double priceValue = Double.parseDouble(priceString);
                String descriptionValue = foodDescription.getText().toString();
                // ContentValues class is implemented for containing the data above so it that can be passed onto.
                ContentValues values = new ContentValues();
                values.put("name", foodNameValue);
                values.put("price", priceValue);
                values.put("description", descriptionValue);


            }
        });







    }
}