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
    private List<Welcome> welcomes = new ArrayList<>();
    private Context mContext;
    private ImageAdapter adapter;
    public ImageProfileAdapter(Context context) {
        this.mContext = context;
    }

    public void setListImage(List<Welcome> welcomes) {
        Log.d("sizeM",welcomes.size()+"chao abc");
        this.welcomes = welcomes;
    }

    @NonNull
    @NotNull
    @Override
    public ImageProfileAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.
                from(parent.getContext()).inflate(R.layout.activity_image_profile,parent,false) );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ImageProfileAdapter.ViewHolder holder, int position) {
        holder.bind(welcomes.get(position));
    }

    @Override
    public int getItemCount() {
        return welcomes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView itemImageAvatar;
        TextView textUser,textDate,textDes,textLike,location,nameImageProfile;
        RecyclerView recycleImageProfile;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            adapter = new ImageAdapter(mContext);
            recycleImageProfile=itemView.findViewById(R.id.recycleImageProfile);

            adapter.setListImage(welcomes);
            recycleImageProfile.setAdapter(adapter);
//            imageView = itemView.findViewById(R.id.item_photo);
//            itemImageAvatar = itemView.findViewById(R.id.itemImageAvatar);
//            textUser = itemView.findViewById(R.id.txtName);
//            textLike=itemView.findViewById(R.id.textLike);
//            textDate = itemView.findViewById(R.id.txtDate);
//            textDes = itemView.findViewById(R.id.txtDes);
//            location = itemView.findViewById(R.id.location);
//            nameImageProfile = itemView.findViewById(R.id.nameImageProfile);
        }

        public void bind(Welcome welcome){
//            adapter.setListImage(welcomes);
//            recycleImageProfile.setAdapter(adapter);

//            textUser.setText(welcomes.getName());
//            textDate.setText(welcomes.getP);
//            textDes.setText(welcomes.getAlt_description());
//            textLike.setText(String.valueOf(welcomes.getLikes()));
//            textUser.setText(welcome.getUser().getName());
//            textDate.setText(welcome.getCreated_at().substring(0,10));
//            textDes.setText(welcome.getAlt_description());
//            textLike.setText(String.valueOf(welcome.getLikes()));
//            Glide
//                    .with(mContext)
//                    .load(welcome.getUrls().getSmall())
//                    .centerCrop()
//                    .into(imageView);
//            Glide
//                    .with(mContext)
//                    .load(welcome.getUser().getProfile_image().getLarge())
//                    .centerCrop()
//                    .into(itemImageAvatar);
        }
    }
}
