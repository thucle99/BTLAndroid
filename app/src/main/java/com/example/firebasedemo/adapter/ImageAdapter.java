package com.example.firebasedemo.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.firebasedemo.model.getall.Welcome;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{
    private List<Welcome> listImage = new ArrayList<>();
    private Context mContext;
    public ImageAdapter(Context context) {
        this.mContext = context;
    }

    public void setListImage(List<Welcome> listImage) {
        this.listImage = listImage;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.
                from(parent.getContext()).inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ImageAdapter.ImageViewHolder holder, int position) {
        holder.bind(listImage.get(position));
    }

    @Override
    public int getItemCount() {
        return listImage.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        ImageView itemImageAvatar;
        TextView textUser,textDate,textDes,textLike;
        LinearLayout profileInformation;
        public ImageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_photo);
            itemImageAvatar = itemView.findViewById(R.id.itemImageAvatar);
            textUser = itemView.findViewById(R.id.txtName);
            textLike=itemView.findViewById(R.id.textLike);
            textDate = itemView.findViewById(R.id.txtDate);
            textDes = itemView.findViewById(R.id.txtDes);
            profileInformation=itemView.findViewById(R.id.profileInformation);
        }
        public void bind(Welcome welcome){

            textUser.setText(welcome.getUser().getName());
            textDate.setText(welcome.getCreated_at().substring(0,10));
            textDes.setText(welcome.getAlt_description());
            textLike.setText(String.valueOf(welcome.getLikes()));
            Glide
            .with(mContext)
            .load(welcome.getUrls().getSmall())
            .centerCrop()
            .into(imageView);
            Glide
            .with(mContext)
            .load(welcome.getUser().getProfile_image().getLarge())
            .centerCrop()
            .into(itemImageAvatar);
        }
    }
}
