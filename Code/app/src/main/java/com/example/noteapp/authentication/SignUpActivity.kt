package com.example.noteapp.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteapp.R
import com.example.noteapp.views.HomeViewActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private var firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        bindListeners()
    }
    private fun bindListeners(){
        go_to_log_in.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        sign_up_button.setOnClickListener {
            val email = sign_up_email.text.toString()
            val password = sign_up_password.text.toString()
            val confirm = confirm_password.text.toString()
            val error = verifyInputs(email,password,confirm)

            if (!error.equals("")){
                Toast.makeText(this,error,Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                Toast.makeText(this,"Successfully logging in",Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeViewActivity::class.java)
                startActivity(intent)
            }

        }
    }
    private fun verifyInputs(email:String,password:String,confirm:String):String{
        if (email.isEmpty() || password.isEmpty() || confirm.isEmpty()){
            return "Fill up the fields properly"
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Not a valid email address"
        }
        if (!password.equals(confirm)){
            return "Passwords do not match"
        }
        return ""
    }
}
