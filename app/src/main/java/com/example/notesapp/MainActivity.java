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

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button SignUp,LogIn;
    private EditText mailText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        SignUp=findViewById(R.id.sign_up_button);
        LogIn=findViewById(R.id.log_in_button);
        mailText=findViewById(R.id.log_in_mail);
        passwordText= findViewById(R.id.log_in_password);

       /* if (firebaseAuth.getCurrentUser() != null){
            System.out.println("Boogalu");
        } */

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mailText.getText().toString();
                String password=passwordText.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fill up the fields properly", Toast.LENGTH_LONG).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(MainActivity.this,profile.class));
                    }
                });
            }
        });


    }


}
