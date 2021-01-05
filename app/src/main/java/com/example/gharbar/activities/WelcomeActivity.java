package com.example.gharbar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gharbar.R;

public class WelcomeActivity extends AppCompatActivity {

    Button btnSignUp, btnSignIn, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        btnSignUp = findViewById(R.id.signup);
        btnSignIn = findViewById(R.id.signin);
        btn= findViewById(R.id.button);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, BuyActivity.class);
                startActivity(intent);
            }
        });
    }
}