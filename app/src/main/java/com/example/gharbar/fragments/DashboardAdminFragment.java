package com.example.gharbar.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gharbar.R;
import com.example.gharbar.activities.AdminAddCategoryActivity;

public class DashboardAdminFragment extends Fragment {
    Button btnCategory,btnAdmin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard_admin, container, false);
        btnAdmin=view.findViewById(R.id.btnAdmin);
        btnCategory=view.findViewById(R.id.btnCategory);
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AdminAddCategoryActivity.class));
            }
        });
        return view;
    }
}