package com.example.gharbar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.gharbar.R;
import com.example.gharbar.fragments.ChatAdminFragment;
import com.example.gharbar.fragments.DashboardAdminFragment;
import com.example.gharbar.fragments.RequestsAdminFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin);
        bottomNavigationView = findViewById(R.id.bottom_nav1);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id){
                    case R.id.request:
                        RequestsAdminFragment requestsAdminFragment= new RequestsAdminFragment();
                        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, requestsAdminFragment);
                        fragmentTransaction.commit();


                        break;
                    case R.id.chat:
                        ChatAdminFragment chatAdminFragment = new ChatAdminFragment();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame_layout, chatAdminFragment);
                        fragmentTransaction1.commit();

                        break;
                    case R.id.dashboard:
                        DashboardAdminFragment dashboardAdminFragment = new DashboardAdminFragment();
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.frame_layout, dashboardAdminFragment);
                        fragmentTransaction2.commit();



                        break;
                }


                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.request);
    }
}