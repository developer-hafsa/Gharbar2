package com.example.gharbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.example.gharbar.adapter.AllImagesAdapter;
import com.example.gharbar.callback.ActionCallback;
import com.example.gharbar.utills.BaseHelper;
import com.example.gharbar.utills.Utills;

import java.util.ArrayList;
import java.util.List;

public class AddImages extends AppCompatActivity {
    public static final int REQ_CODE = 1001;
    RecyclerView recyclerView;
    Button btnAdd;
    TextView tvDone;
    AllImagesAdapter adapter;
    List<String> listOfImages=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_images);
        recyclerView=findViewById(R.id.recyclerView);
        tvDone=findViewById(R.id.tvDone);
        btnAdd=findViewById(R.id.btnAdd);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utills.loadImages(AddImages.this,AddImages.this, REQ_CODE);
            }
        });
        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               upload();
            }
        });

    }

    private void upload() {
        Utills.showDialog(this);
        for (int i=0;i<listOfImages.size();i++) {
            int finalI = i;
            Utills.uploadImage(AddImages.this, "products", listOfImages.get(i), new ActionCallback() {
                @Override
                public void oSucess(String s) {
                    BaseHelper.imgeUrls.add(s);
                    if((listOfImages.size()-1)== finalI) {
                        Utills.dissmiss();
                        finish();
                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_CODE && data!=null){
            List<Image> images = ImagePicker.getImages(data);
            for (Image image: images) {
                listOfImages.add(image.getPath());
            }
            adapter=new AllImagesAdapter(listOfImages,AddImages.this);
            recyclerView.setAdapter(adapter);

        }

    }
}