package com.example.gharbar.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdminRequestAdapter extends RecyclerView.Adapter<AdminRequestAdapter.AdminRequestVHolder>{

    @NonNull
    @Override
    public AdminRequestVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminRequestVHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AdminRequestVHolder extends RecyclerView.ViewHolder{

        public AdminRequestVHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}