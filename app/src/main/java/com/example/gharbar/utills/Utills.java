package com.example.gharbar.utills;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.example.gharbar.R;
import com.example.gharbar.callback.ActionCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utills {
    public static ProgressDialog dialog;

    public static void showDialog(Context context) {
        dialog = new ProgressDialog(context);
        dialog.setMessage("Loading...");
        dialog.show();
    }

    public static void dissmiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static void loadImages(Context context, final Activity activity, final int reqCode) {
        Dexter.withContext(context)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                if (multiplePermissionsReport.areAllPermissionsGranted()) {
                    Log.e("multiplePermissions", "multiplePermissionsReport");
                    ArrayList<Image> list = new ArrayList<>();
                    ImagePicker.create(activity)
                            .limit(10)
                            .folderMode(true)
                            .origin(list)
                            .showCamera(true)
                            .start(reqCode);
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    public static void loadImages(Context context, final Fragment activity, final int reqCode) {
        Dexter.withContext(context)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_GSERVICES).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                if (multiplePermissionsReport.areAllPermissionsGranted()) {
                    ArrayList<Image> list = new ArrayList<>();
                    ImagePicker.create(activity)
                            .limit(10)
                            .folderMode(true)
                            .origin(list)
                            .showCamera(true)
                            .start(reqCode);
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    public static void showImge(Context context, String path, ImageView imageView) {
        //Picasso.get().load(path).into(imageView);
        Glide.with(context).load(path).placeholder(R.drawable.bg1).into(imageView);
    }

    public static void uploadImage(Context context, String folderName, String path, ActionCallback callback) {
        String imgName = System.currentTimeMillis() + "" + Uri.parse(path).getLastPathSegment();
        StorageReference ref = FirebaseStorage.getInstance().getReference(folderName).child(imgName);
        File f = new File(path);
        //ref.putFile(Uri.fromFile(f));
        ref.putFile(Uri.fromFile(f)).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()) {
                    ref.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                callback.oSucess("" + task.getResult());
                                Log.e("getDownloadUrl", "getException" + task.getException());

                            } else {
                                Toast.makeText(context, "" + task.getException(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                } else {
                    Log.e("getException", "getException" + task.getException());
                    Toast.makeText(context, "" + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
