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

import java.net.IDN;

public class ViewRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);
        FragmentTransaction fragmentTransact = getSupportFragmentManager().beginTransaction();
        fragmentTransact.add(R.id.fragment_container_view, FragmentActivity.class,null);
        fragmentTransact.commit();
        long ID = getIntent().getLongExtra("ID",0);
    }
}