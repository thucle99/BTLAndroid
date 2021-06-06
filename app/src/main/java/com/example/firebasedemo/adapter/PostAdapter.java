package com.example.firebasedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firebasedemo.R;
import com.example.firebasedemo.activity.EditProfileActivity;
import com.example.firebasedemo.model.getall.MyPost;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PostAdapter extends
        RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context context;
    private List<MyPost> myPosts;
    private FirebaseUser userCurrent;
    private FirebaseStorage storage;
    private String nameProfile;
    private StorageReference storageRef,mountainImagesRef;
    private StorageReference profileRef,storageReference;
    private FirebaseAuth fAuth;

    public PostAdapter(Context context, List<MyPost> myPosts,String nameProfile) {
        this.context = context;
        this.myPosts = myPosts;
        this.nameProfile=nameProfile;
    }

    @NonNull
    @NotNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.item_post,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PostAdapter.ViewHolder holder, int position) {
        holder.name.setText(nameProfile);
        holder.desc.setText(myPosts.get(position).getDescribe());
        holder.date.setText(myPosts.get(position).getDate());

        userCurrent = FirebaseAuth.getInstance().getCurrentUser();
        storageRef = FirebaseStorage.getInstance().getReference();
        mountainImagesRef = storageRef.child("images/" +userCurrent.getUid()+"/"
                +myPosts.get(position).getUrlImage()+ ".jpg");

        mountainImagesRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context)
                .load(uri)
                .into(holder.item_photo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc, date;
        ImageView item_photo,itemImageAvatar;
        public ViewHolder(@NonNull @NotNull View v) {
            super(v);
            name=v.findViewById(R.id.txtName);
            desc=v.findViewById(R.id.txtDes);
            date=v.findViewById(R.id.txtDate);
            item_photo=v.findViewById(R.id.item_photo);
            itemImageAvatar=v.findViewById(R.id.itemImageAvatar);
            fAuth = FirebaseAuth.getInstance();
            storageReference = FirebaseStorage.getInstance().getReference();

            profileRef = storageReference.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
            profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).into(itemImageAvatar);
                }
            });
        }
    }
}
