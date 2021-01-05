package com.example.gharbar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gharbar.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(this, "success nnmnmnnmnm", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "maseera", Toast.LENGTH_SHORT).show();
    }
}