package com.example.firebasedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasedemo.R;
import com.example.firebasedemo.activity.EditContactActivity;
import com.example.firebasedemo.model.getall.Contact;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    Context mContext;
    List<Contact> contacts;
    public ContactAdapter(Context mContext, List<Contact> contacts) {
        this.mContext = mContext;
        this.contacts = contacts;
    }

    @NonNull
    @NotNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.item_contact,parent,false);
        ViewHolder todoViewHolder=new ViewHolder(view);
        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ContactAdapter.ViewHolder holder, int position) {
        holder.textViewName.setText(contacts.get(position).getName());
        holder.textViewAddress.setText(contacts.get(position).getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, EditContactActivity.class);
                intent.putExtra("contact",contacts.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewAddress, textViewDateOfBirth,textViewEmail;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textViewName);
            textViewAddress=itemView.findViewById(R.id.textViewAddress);
        }
    }
}
