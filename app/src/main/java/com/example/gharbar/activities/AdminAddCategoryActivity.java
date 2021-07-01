package com.example.gharbar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gharbar.R;
import com.example.gharbar.adapter.AdminCategoryAdapter;
import com.example.gharbar.model.String;
import com.example.gharbar.utills.MyApplication;
import com.example.gharbar.utills.Utills;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AdminAddCategoryActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    AdminCategoryAdapter adapter;
    List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_category);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        load();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    void showDialog(){
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.add_category_layout, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();
        Button btnSave=view.findViewById(R.id.btnSave);
        final EditText etName=view.findViewById(R.id.etName);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(etName.getText().toString())){
                saveCategory(etName.getText().toString());

                alertDialog.dismiss();
                }else {
                    Toast.makeText(AdminAddCategoryActivity.this, "Please enter category name", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.show();

    }

    private void saveCategory(java.lang.String string) {
        Utills.showDialog(this);
        java.lang.String key = MyApplication.catagoriesRef.push().getKey();
        String category=new String();
        category.id=key;
        category.name=string;
        MyApplication.catagoriesRef.child(key).setValue(category).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utills.dissmiss();
                    list.clear();
                    load();
                    Toast.makeText(AdminAddCategoryActivity.this, "Category Added Successfully", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(AdminAddCategoryActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void load(){
        Utills.showDialog(this);
        MyApplication.catagoriesRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d:snapshot.getChildren()) {
                    Log.e("DataSnapshot",""+new Gson().toJson(d.getKey()));
                    if(d.getValue()!=null) {
                        list.add(d.getValue(String.class));
                    }
                }
                Log.e("DataSnapshot",""+list.size());
                adapter=new AdminCategoryAdapter(list,AdminAddCategoryActivity.this);
                recyclerView.setAdapter(adapter);
                Utills.dissmiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Utills.dissmiss();
            }
        });
    }

}