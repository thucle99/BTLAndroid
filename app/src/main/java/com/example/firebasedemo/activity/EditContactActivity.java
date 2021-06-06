package com.example.firebasedemo.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebasedemo.R;
import com.example.firebasedemo.model.getall.Contact;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class EditContactActivity extends AppCompatActivity {
    private static final String TAG = "Todo";
    private EditText editNameContact, editPhoneContact, editEmailContact, editDateContact;
    private Button btnUpdateContact, btnCancelContact, btnDeleteContact;
    private Spinner spEditContact;
    private String[] cities;
    private DatabaseReference reference;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        initView();
        addSpinner();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        editDateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(EditContactActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        editDateContact.setText(dayOfMonth + " / " + (month + 1) + " / " + year);
                    }
                }, mYear, mMonth, mDay);
                dialog.show();
            }
        });

        btnCancelContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Intent intent = getIntent();
        if (intent.getSerializableExtra("contact") != null) {
            final Contact contact = (Contact) intent.getSerializableExtra("contact");
            editNameContact.setText(contact.getName());
            editPhoneContact.setText(contact.getPhone());
            editEmailContact.setText(contact.getEmail());
            editDateContact.setText(contact.getDate());

            reference = FirebaseDatabase.getInstance().getReference().child("Contacts").
                    child(fAuth.getCurrentUser().getUid()).
                    child("contact" + contact.getKey());

            btnUpdateContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contact editContac = new Contact();
                    editContac.setName(editNameContact.getText().toString());
                    editContac.setPhone(editPhoneContact.getText().toString());
                    editContac.setEmail(editEmailContact.getText().toString());
                    editContac.setDate(editDateContact.getText().toString());
                    editContac.setAddress(spEditContact.getSelectedItem().toString());
                    editContac.setKey(contact.getKey());

                    reference.setValue(editContac).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),
                                    "Update success.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),
                                    "Failed to update value.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
            btnDeleteContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reference.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),
                                    "Delete success.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),
                                    "Delete failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

        }
    }

    private void addSpinner() {
        cities = new String[]{"Hà Nội", "Sài Gòn", "Đà Nẵng", "Lạng Sơn", "Nam Định", "Lào Cai"};
        ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner, cities);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spEditContact.setAdapter(adapter);
    }

    private void initView() {
        editNameContact = findViewById(R.id.editNameContact);
        editPhoneContact = findViewById(R.id.editPhoneContact);
        editEmailContact = findViewById(R.id.editEmailContact);
        editDateContact = findViewById(R.id.editDateContact);
        spEditContact = findViewById(R.id.spEditContact);
        btnUpdateContact = findViewById(R.id.btnUpdateContact);
        btnCancelContact = findViewById(R.id.btnCancelContact);
        btnDeleteContact = findViewById(R.id.btnDeleteContact);

        fAuth = FirebaseAuth.getInstance();
    }
}
