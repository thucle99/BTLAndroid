package com.example.firebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasedemo.activity.AddContactActivity;
import com.example.firebasedemo.adapter.ContactAdapter;
import com.example.firebasedemo.model.getall.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {
    private FloatingActionButton addIcon;
    private RecyclerView recycleContact;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private List<Contact> contacts;
    private ContactAdapter adapter;
    private ProgressBar progressBarLoadingContact;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_contact, container, false);
        addIcon=v.findViewById(R.id.addIcon);
        progressBarLoadingContact=v.findViewById(R.id.progressBarLoadingContact);
        progressBarLoadingContact.setVisibility(View.VISIBLE);
        recycleContact=v.findViewById(R.id.recycleContact);

        recycleContact.setLayoutManager(new LinearLayoutManager(getContext()));
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Contacts");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                contacts = new ArrayList<Contact>();
                for(DataSnapshot item: snapshot.getChildren())
                {
                    Contact contact = item.getValue(Contact.class);
                    contacts.add(contact);
                }
                adapter = new ContactAdapter(getContext(),
                        contacts);
                recycleContact.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBarLoadingContact.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddContactActivity.class));
            }
        });

        return v;
    }
}
