package com.example.myfoodcriticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

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
    }
}