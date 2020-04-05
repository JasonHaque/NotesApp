package com.example.noteapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteapp.R
import com.example.noteapp.classes.Notes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNoteActivity : AppCompatActivity() {
    private var database = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        bindListeners()
    }
    private fun bindListeners(){
        save_note.setOnClickListener {
            val noteName = note_name.text.toString()
            val noteContent = note_description.text.toString()
            val error = verifyInputs(noteName, noteContent)
            if(!error.equals("")){
                Toast.makeText(this,error,Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val note = Notes(noteName, noteContent)
            val usermail = FirebaseAuth.getInstance().currentUser?.email.toString()
            val split =usermail.split("@")
            val user = split[0]
            val key = database.child("Users").child(user).push().key
            note.uuid = key
            database.child("Users").child(user).child(key!!)
                .setValue(note).addOnSuccessListener {
                    Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
                }


        }
    }

    private fun verifyInputs(noteName:String,noteContent:String):String{
        if (noteName.isEmpty() || noteContent.isEmpty()){
            return "Fill up the fields properly"
        }


        return ""
    }
}
