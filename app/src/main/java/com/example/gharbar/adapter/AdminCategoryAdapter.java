package com.example.gharbar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gharbar.R;
import com.example.gharbar.model.String;
import com.example.gharbar.utills.MyApplication;
import com.example.gharbar.utills.Utills;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;

public class AdminCategoryAdapter extends RecyclerView.Adapter<AdminCategoryAdapter.AdminCategoryVHolder>{
List<String>  list;
Context context;

    public AdminCategoryAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdminCategoryVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false);
        return new AdminCategoryVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminCategoryVHolder holder, int position) {
        final String category = list.get(position);
        holder.tvName.setText(""+category.name);
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
saveCategory(category,true);
            }
        });
        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdminCategoryVHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView ivEdit,ivDelete;
        public AdminCategoryVHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            ivDelete=itemView.findViewById(R.id.ivDelete);
            ivEdit=itemView.findViewById(R.id.ivEdit);
        }
    }
    private void saveCategory(String category, final boolean isDelete) {
        Utills.showDialog(context);
        java.lang.String key = category.id;
        final String c1=category;
        if(isDelete==true){
            category=null;
        }

        Task<Void> child = MyApplication.catagoriesRef.child(key).setValue(category).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Utills.dissmiss();
                    if(isDelete) {
                        Toast.makeText(context, "Delete Successfully", Toast.LENGTH_SHORT).show();
                        if(list.contains(c1)) {
                            list.remove(c1);
                        }
                    }else {
                        Toast.makeText(context, "Update Successfully", Toast.LENGTH_SHORT).show();
                    }
                    notifyDataSetChanged();

                }else {
                    Toast.makeText(context, ""+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}