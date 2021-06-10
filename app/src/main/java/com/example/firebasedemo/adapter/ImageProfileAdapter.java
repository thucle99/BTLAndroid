package com.example.firebasedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firebasedemo.R;
import com.example.firebasedemo.activity.ImageProfileActivity;
import com.example.firebasedemo.model.getall.Welcome;
import com.example.firebasedemo.model.user.Custom;
import com.example.firebasedemo.model.user.WelcomeUser;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ImageProfileAdapter extends RecyclerView.Adapter<ImageProfileAdapter.ViewHolder>{
    private List<WelcomeUser> welcomeUsers = new ArrayList<>();
    private List<Custom> customs= new ArrayList<>();
    private String locationString;
    private String nameString;
    private Context mContext;
    public ImageProfileAdapter(Context context) {
        this.mContext = context;
    }

    public void setListImage(List<Custom> customs,String locationString,String nameString) {
        Log.d("sizeM",customs.size()+"chao abc");
        this.customs = customs;
        this.locationString=locationString;
        this.nameString=nameString;
    }

    @NonNull
    @NotNull
    @Override
    public ImageProfileAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.
                from(parent.getContext()).inflate(R.layout.activity_image_profile,parent,true) );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ImageProfileAdapter.ViewHolder holder, int position) {
        holder.bind(customs.get(position));
    }

    @Override
    public int getItemCount() {
        return welcomeUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView itemImageAvatar;
        TextView textUser,textDate,textDes,textLike,location,nameImageProfile;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_photo);
            itemImageAvatar = itemView.findViewById(R.id.itemImageAvatar);
            textUser = itemView.findViewById(R.id.txtName);
            textLike=itemView.findViewById(R.id.textLike);
            textDate = itemView.findViewById(R.id.txtDate);
            textDes = itemView.findViewById(R.id.txtDes);
            location = itemView.findViewById(R.id.location);
            nameImageProfile = itemView.findViewById(R.id.nameImageProfile);
        }

        public void bind(Custom customs){

//            textUser.setText(welcomeUser.getName());
            location.setText(locationString);
            nameImageProfile.setText(nameString);
            textDate.setText(customs.getSource().getCover_photo().getCreated_at());
            textDes.setText(customs.getSource().getCover_photo().getDescription());
//            textLike.setText(String.valueOf(welcomeUser.getLikes()));
            Glide
                    .with(mContext)
                    .load(customs.getSource().getCover_photo().getUrls().getSmall())
                    .centerCrop()
                    .into(imageView);
//            Glide
//                    .with(mContext)
//                    .load(welcomeUser.getUser().getProfile_image().getLarge())
//                    .centerCrop()
//                    .into(itemImageAvatar);
        }
    }
}
