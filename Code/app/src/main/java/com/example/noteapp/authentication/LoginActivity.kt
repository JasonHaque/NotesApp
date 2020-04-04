package com.example.noteapp.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bindListeners()
    }

    private fun bindListeners(){
        go_to_sign_up.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        log_in_button.setOnClickListener {
            val email = email_text_field.text.toString()
            val password = password_text_field.text.toString()
            val error = verifyInputs(email, password)

            if (!error.equals("")){
                Toast.makeText(this,error,Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

        }
    }
    private fun verifyInputs(email:String,password:String):String{
        if (email.isEmpty() || password.isEmpty()){
            return "Fill up the fields properly"
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Not a valid email address"
        }

        return ""
    }
}
