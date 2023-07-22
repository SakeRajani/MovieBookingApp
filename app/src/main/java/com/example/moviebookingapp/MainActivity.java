package com.example.moviebookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Movie Booking");
        addFragment();;
    }

    public void addFragment(){
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();

        MovieListFragment fragment=new MovieListFragment();
        fragmentTransaction.add(R.id.fragment1,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}