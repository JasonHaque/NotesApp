package com.example.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button signUp;
    private EditText signUpMail,signUpPassword,confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth = FirebaseAuth.getInstance();
        signUp = findViewById(R.id.sign_up);
        signUpMail=findViewById(R.id.sign_up_mail);
        signUpPassword=findViewById(R.id.sign_up_password);
        confirmPassword= findViewById(R.id.sign_up_confirm);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=signUpMail.getText().toString();
                String password=signUpPassword.getText().toString();
                String confirm=confirmPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignUpActivity.this,"Fill up the fields properly", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!password.equals(confirm)){
                    Toast.makeText(SignUpActivity.this,"Passwords Don't match",Toast.LENGTH_LONG).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(SignUpActivity.this,profile.class));
                    }
                });
            }
        });

    }
}
