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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebasedemo.FragmentProfile;
import com.example.firebasedemo.MainActivity;
import com.example.firebasedemo.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class AddPostActivity extends AppCompatActivity {
    private EditText edDes;
    private TextView txtName;
    private ImageView imagePicker,imageAvatar;
    private Button btnPost;
    private DatabaseReference reference;
    private StorageReference storageRef;
    private StorageReference mountainsRef;
    private StorageReference profileRef ;
    private FirebaseAuth fAuth;
    private FirebaseUser user;
    private Bitmap bitmap;
    private Integer TodoNum = new Random().nextInt();
    private String keytodo = Integer.toString(TodoNum);
    private static final int RESULT_LOAD_IMG = 538;
    private Uri uri;

    public AddPostActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();

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
                uploadImage();
                Date date = new Date();

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String formatted = format1.format(cal.getTime());

                reference = FirebaseDatabase.getInstance().getReference().
                        child("MyPost").
                        child(user.getUid()).
                        child("post" + keytodo);

                    Map<String, Object> data= new HashMap<>();
                    data.put("describe", edDes.getText().toString());
                    data.put("date",formatted);
                    data.put("urlImage",keytodo);
                    reference.setValue(data);
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
        imageAvatar=findViewById(R.id.imageAvatar);
        txtName=findViewById(R.id.txtName);
        Intent intent = getIntent();
        txtName.setText(intent.getStringExtra("nameProfile"));

        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();
        storageRef = FirebaseStorage.getInstance().getReference();
        mountainsRef = storageRef.child("images/" +user.getUid()+"/" +keytodo+ ".jpg");

        profileRef = storageRef.child("users/"+user.getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(imageAvatar);
            }
        });
    }

    private void uploadImage() {
        ProgressDialog progressDialog
                = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        imagePicker.setDrawingCacheEnabled(true);
        imagePicker.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) imagePicker.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = mountainsRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(AddPostActivity.this, "Image Upload fail!!", Toast.LENGTH_SHORT).show();
                finish();
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(AddPostActivity.this, "Image Uploaded!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnProgressListener(
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
                });;
    }

}
