package com.example.gharbar.utills;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyApplication extends Application {
    public static DatabaseReference catagoriesRef,userRef;
    @Override
    public void onCreate() {
        super.onCreate();
        catagoriesRef= FirebaseDatabase.getInstance().getReference("category");
        userRef= FirebaseDatabase.getInstance().getReference("users");
    }
}
