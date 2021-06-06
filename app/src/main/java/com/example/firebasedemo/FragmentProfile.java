package com.example.firebasedemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasedemo.activity.AddContactActivity;
import com.example.firebasedemo.activity.AddPostActivity;
import com.example.firebasedemo.activity.EditProfileActivity;
import com.example.firebasedemo.adapter.ContactAdapter;
import com.example.firebasedemo.adapter.PostAdapter;
import com.example.firebasedemo.model.getall.Contact;
import com.example.firebasedemo.model.getall.MyPost;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FragmentProfile extends Fragment {
    private Button btnAdd;
    private TextView nameProfile,emailProfile,phoneProfile;
    private LinearLayout editProfile;
    private ImageView avatarProfile,avatar;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String userId;
    private FirebaseUser user;
    private StorageReference storageReference;

    private RecyclerView recycleProfile;
    List<MyPost> myPosts;
    private PostAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_profile, container, false);

        recycleProfile=v.findViewById(R.id.recycleProfile);
        recycleProfile.setLayoutManager(new LinearLayoutManager(getContext()));
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("MyPost");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myPosts = new ArrayList<MyPost>();
                for(DataSnapshot item: snapshot.getChildren())
                {
                    MyPost myPost = item.getValue(MyPost.class);
                    myPosts.add(myPost);
                }
                adapter = new PostAdapter(getContext(),
                        myPosts,nameProfile.getText().toString());
                recycleProfile.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        init(v);

        StorageReference profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(avatarProfile);
                Picasso.get().load(uri).into(avatar);
            }
        });

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable DocumentSnapshot documentSnapshot, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if(documentSnapshot.exists()){
                    phoneProfile.setText(documentSnapshot.getString("phone"));
                    nameProfile.setText(documentSnapshot.getString("fName"));
                    emailProfile.setText(documentSnapshot.getString("email"));

                }else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),
                        AddPostActivity.class);
                startActivity(intent);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),EditProfileActivity.class);
                i.putExtra("fullName",nameProfile.getText().toString());
                i.putExtra("email",emailProfile.getText().toString());
                i.putExtra("phone",phoneProfile.getText().toString());
                startActivity(i);

            }
        });

        return v;
    }

    private void init(View v) {
        nameProfile=v.findViewById(R.id.nameProfile);
        emailProfile=v.findViewById(R.id.emailProfile);
        phoneProfile=v.findViewById(R.id.phoneProfile);
        avatarProfile=v.findViewById(R.id.avatarProfile);
        avatar=v.findViewById(R.id.avatar);
        btnAdd=v.findViewById(R.id.btnAdd);
        editProfile=v.findViewById(R.id.editProfile);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();
    }


}