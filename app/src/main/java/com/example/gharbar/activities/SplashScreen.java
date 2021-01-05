package com.example.gharbar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.gharbar.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getSupportActionBar().hide();

        Handler handler= new Handler();
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, WelcomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        };
        handler.postDelayed(runnable, 3000);

    }
}