package com.example.noteapp.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp.R
import com.example.noteapp.authentication.LoginActivity
import com.example.noteapp.views.HomeViewActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = checkUserStatus()
        startActivity(intent)

    }

    private fun checkUserStatus() : Intent{
        if (FirebaseAuth.getInstance().currentUser != null){
            val intent = Intent(this,HomeViewActivity::class.java)
            return intent
        }
        val intent = Intent(this,LoginActivity::class.java)
        return intent
    }
}
