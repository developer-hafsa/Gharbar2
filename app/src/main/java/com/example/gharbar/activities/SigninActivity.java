package com.example.gharbar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gharbar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnSignin;
    String email, password;
    FirebaseAuth mAuth;
    TextView Create;

    @Override
    public void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null)
        {
            Intent intent= new Intent(SigninActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
        etEmail=findViewById(R.id.email);
        etPassword=findViewById(R.id.password);
        btnSignin= findViewById(R.id.button1);
        Create= findViewById(R.id.create);
        mAuth= FirebaseAuth.getInstance();
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email= etEmail.getText().toString();
                password= etPassword.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SigninActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent= new Intent(SigninActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(SigninActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SigninActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });


    }
}