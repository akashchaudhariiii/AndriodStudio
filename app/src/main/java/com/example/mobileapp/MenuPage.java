package com.example.mobileapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MenuPage extends AppCompatActivity {

    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        // Initialize the RelativeLayout
        layout = findViewById(R.id.layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if (id == R.id.menu_red) {
            layout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            return true;
        } else if (id == R.id.menu_green) {
            layout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            return true;
        } else if (id == R.id.menu_yellow) {
            layout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
