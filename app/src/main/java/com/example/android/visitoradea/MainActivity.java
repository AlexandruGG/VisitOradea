package com.example.android.visitoradea;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Set the adapter for the fragments on the viewpager
        viewPager.setAdapter(new AttractionAdapter(this, getSupportFragmentManager()));

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Connect the tab layout with the view pager
        tabLayout.setupWithViewPager(viewPager);
    }
}

