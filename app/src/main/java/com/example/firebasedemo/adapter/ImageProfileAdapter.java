package com.example.firebasedemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasedemo.R;
import com.example.firebasedemo.model.getall.Welcome;
import com.example.firebasedemo.model.user.WelcomeUser;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ImageProfileAdapter extends RecyclerView.Adapter<ImageProfileAdapter.ViewHolder>{
    private List<WelcomeUser> welcomeUsers = new ArrayList<>();
    private Context mContext;
    public ImageProfileAdapter(Context context) {
        this.mContext = context;
    }

    public void setListImage(List<WelcomeUser> welcomeUsers) {
        this.welcomeUsers = welcomeUsers;
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

    }

    @Override
    public int getItemCount() {
        return welcomeUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
