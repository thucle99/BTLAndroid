package com.example.firebasedemo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebasedemo.FragmentProfile;
import com.example.firebasedemo.MainActivity;
import com.example.firebasedemo.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class AddPostActivity extends AppCompatActivity {
    private EditText edDes;
    private ImageView imagePicker;
    private Button btnPost;
    private DatabaseReference reference;
    private StorageReference storageRef;
    private StorageReference mountainsRef;
    private StorageReference mountainImagesRef ;
    private FirebaseStorage storage;
    private ByteArrayOutputStream baos;
    private Bitmap bitmap;
    private Integer TodoNum = new Random().nextInt();
    private String keytodo = Integer.toString(TodoNum);
    private UploadTask uploadTask;
    private InputStream stream;
    private static final int RESULT_LOAD_IMG = 538;
    private Uri uri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();

//        imagePicker.setDrawingCacheEnabled(true);
//        imagePicker.buildDrawingCache();
//        bitmap=((BitmapDrawable) imagePicker.getDrawable()).getBitmap();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] data = baos.toByteArray();
//
//        try {
//            stream = new FileInputStream(new File("path/to/images/rivers.jpg"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        uploadTask = mountainsRef.putBytes(data);
//        uploadTask.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull @NotNull Exception e) {
//
//            }
//        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//            }
//        });

        imagePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                reference = FirebaseDatabase.getInstance().getReference().
//                        child("MyPost").
//                        child("post" + keytodo);
//
//                    Map<String, Object> data= new HashMap<>();
//                    data.put("name", "Le Trung Thuc");
//                    data.put("describe", edDes.getText().toString());
//                    data.put("date", "25/07/1999");
//                    data.put("key", keytodo);
//
//                    reference.setValue(data);
//                    finish();
                uploadImage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMG){
            uri = data.getData();
            imagePicker.setImageURI(uri);
        }
    }

    private void initView() {
        edDes=findViewById(R.id.edDes);
        imagePicker=findViewById(R.id.imagePicker);
        btnPost=findViewById(R.id.btnPost);

//        storage = FirebaseStorage.getInstance();
//        storageRef = storage.getReference();


//        mountainsRef = storageRef.child("mountains.jpg");
//        mountainImagesRef = storageRef.child("images/mountains.jpg");
//        baos = new ByteArrayOutputStream();
    }

    private void uploadImage()
    {
        if (uri != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageRef
                    .child(
                            "images/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(uri)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(AddPostActivity.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                    Log.d("img", "chao anh em");
                                    Intent intent = new Intent(AddPostActivity.this,
                                            FragmentProfile.class);
                                    startActivity(intent);
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(AddPostActivity.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int)progress + "%");
                                }
                            });
        }
    }
}
