package com.example.firebasedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasedemo.R;
import com.example.firebasedemo.activity.EditProfileActivity;
import com.example.firebasedemo.model.getall.MyPost;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PostAdapter extends
        RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context context;
    List<MyPost> myPosts;
    public PostAdapter(Context context, List<MyPost> myPosts) {
        this.context = context;
        this.myPosts = myPosts;
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
        holder.name.setText(myPosts.get(position).getName());
        holder.desc.setText(myPosts.get(position).getDescribe());
        holder.date.setText(myPosts.get(position).getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, EditProfileActivity.class);
                intent.putExtra("todo",myPosts.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc, date;
        ImageView imageView;
        public ViewHolder(@NonNull @NotNull View v) {
            super(v);
            name=v.findViewById(R.id.txtName);
            desc=v.findViewById(R.id.txtDes);
//            date=v.findViewById(R.id.txtDate);
        }
    }
}
