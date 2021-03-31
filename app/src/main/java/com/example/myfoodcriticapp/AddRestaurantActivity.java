package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRestaurantActivity extends AppCompatActivity {
EditText restaurantName, restaurantAddress, restaurantPhone;
Button continueBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        /**
         * @return the fragment manager that is associated with this activity. Fragment is then
         * initialised with a beginTransaction method.
         */
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();

        // The following EditText views and a button are initialised to the corresponding ids set in activity_add_restaurant xml.
        restaurantName = findViewById(R.id.nameTextbox);
        restaurantAddress = findViewById(R.id.addressTextbox);
        restaurantPhone = findViewById(R.id.phoneTextbox);
        continueBtn = findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /* Values that will be inserted into the database with the following columns: name
            address and phone number passed in as Strings.  */
                String restaurantNameValue = restaurantName.getText().toString();
                String restaurantAddressValue = restaurantAddress.getText().toString();
                String restaurantPhoneNumValue = restaurantPhone.getText().toString();
                // ContentValues class is used for containing data that can be passed onto.
                ContentValues values = new ContentValues();
                values.put("name", restaurantNameValue);
                values.put("address", restaurantAddressValue);
                values.put("phone", restaurantPhoneNumValue);
                // returns the application object context in order to return data
                Database db = new Database(getApplicationContext());
                 /* Calls the addRestaurant() method in database class and save data.
                    Long instance is created
                    to parse the primary key to the next activity as a foreign key use.
                    The startActivity occurs to to initiate the next activity called AddFoodActivity.
                 */
                long restaurantID = db.addRestaurant(values);
                Intent intent = new Intent(AddRestaurantActivity.this,AddFoodActivity.class);
                intent.putExtra("ID",restaurantID);
                startActivity(intent);
            }
        });
    }
}