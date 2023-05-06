package com.example.firebasedemo.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebasedemo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AddContactActivity extends AppCompatActivity {
    private EditText nameContact,phoneContact,emailContact,dateContact;
    private Button btnAddContact;
    private Spinner sp;
    private String[] cities;
    private DatabaseReference reference;
    private Integer TodoNum = new Random().nextInt();
    private String keytodo = Integer.toString(TodoNum);
    private ProgressBar progressBarContact;
    private FirebaseAuth fAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        initView();
        addSpinner();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        dateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(AddContactActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        dateContact.setText(dayOfMonth + " / " + (month + 1) + " / " + year);
                    }
                }, mYear, mMonth, mDay);
                dialog.show();
            }
        });

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=nameContact.getText().toString();
                String p=phoneContact.getText().toString();
                String e=emailContact.getText().toString();
                String d=dateContact.getText().toString();

                if(n.isEmpty()){
                    nameContact.setError("Name is not blank");
                    return;
                }
                if(p.isEmpty()){
                    phoneContact.setError("Phone is not blank");
                    return;
                }
                if(e.isEmpty()){
                    emailContact.setError("Email is not blank");
                    return;
                }
                if(d.isEmpty()){
                    dateContact.setError("Date of Birth is not blank");
                    return;
                }

                progressBarContact.setVisibility(View.VISIBLE);
                reference = FirebaseDatabase.getInstance().getReference().
                        child("Contacts").
                        child(user.getUid()).
                        child("contact" + keytodo);
                Map<String, Object> data= new HashMap<>();
                data.put("name", nameContact.getText().toString());
                data.put("phone", phoneContact.getText().toString());
                data.put("email", emailContact.getText().toString());
                data.put("date", dateContact.getText().toString());
                data.put("address", sp.getSelectedItem().toString());
                data.put("key", keytodo);
                Toast.makeText(AddContactActivity.this, "User Created.", Toast.LENGTH_SHORT).show();

                reference.setValue(data);
                finish();
            }
        });
    }

    private void addSpinner() {
        cities=new String[]{"Hà Nội","Sài Gòn","Đà Nẵng","Lạng Sơn","Nam Định","Lào Cai"};
        ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner,cities);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }

    private void initView() {
        nameContact=findViewById(R.id.nameContact);
        phoneContact=findViewById(R.id.phoneContact);
        emailContact=findViewById(R.id.emailContact);
        dateContact=findViewById(R.id.dateContact);
        sp=findViewById(R.id.sp);
        btnAddContact=findViewById(R.id.btnAddContact);
        progressBarContact = findViewById(R.id.progressBarContact);

        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();
    }
}
