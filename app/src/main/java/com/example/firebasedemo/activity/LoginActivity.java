package com.example.firebasedemo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasedemo.MainActivity;
import com.example.firebasedemo.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity{
    private static final String TAG = "firebase";
    private EditText email,password;
    private Button btnLogin;
    private TextView txtRegister;
    protected FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth = FirebaseAuth.getInstance();
        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e= email.getText().toString();
                String p=password.getText().toString();
                if(e.isEmpty()){
                    email.setError("email is not empty");
                }
                else if(p.isEmpty()){
                    password.setError("password is not empty");
                }
                else if(p.length()<6){
                    password.setError("password must be >= 6 characters");
                }

                mFirebaseAuth.signInWithEmailAndPassword(e,p).
                        addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {

                                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this,
                                        MainActivity.class);

                                startActivity(intent);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this,
                                "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,
                        RegisterActitvity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btnLogin = findViewById(R.id.signin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        txtRegister=findViewById(R.id.txtRegister);
    }

}