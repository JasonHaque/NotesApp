package com.example.notesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {


    private TextView profileText;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileText = findViewById(R.id.profile_view);
        firebaseAuth=FirebaseAuth.getInstance();

        String[] user=firebaseAuth.getCurrentUser().getEmail().split("@");
        String userName=user[0];

        profileText.setText("Welcome "+userName);

    }
}
