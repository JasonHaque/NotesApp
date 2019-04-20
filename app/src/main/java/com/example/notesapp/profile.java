package com.example.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {


    private TextView profileText;
    private FirebaseAuth firebaseAuth;
    private Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileText = findViewById(R.id.profile_view);
        firebaseAuth=FirebaseAuth.getInstance();
        logOut=findViewById(R.id.log_out_button);

        String[] user=firebaseAuth.getCurrentUser().getEmail().split("@");
        String userName=user[0];

        profileText.setText("Welcome "+userName);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(profile.this,MainActivity.class));
            }
        });

    }
}
