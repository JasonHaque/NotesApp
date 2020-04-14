package com.example.firebaseapp.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private var firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        bindListeners()
    }

    fun bindListeners(){
        go_to_log_in.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        sign_up_button.setOnClickListener {
            val email = sign_up_email.text.toString()
            val password = sign_up_password.text.toString()
            val confirmPassword = confirm_password.text.toString()

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this,"FIll em up",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!password.equals(confirmPassword)){
                Toast.makeText(this,"passwords not matched",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                return@addOnSuccessListener

            }

        }
    }
}
