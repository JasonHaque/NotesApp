package com.example.noteapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteapp.R
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNoteActivity : AppCompatActivity() {

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


        }
    }

    private fun verifyInputs(noteName:String,noteContent:String):String{
        if (noteName.isEmpty() || noteContent.isEmpty()){
            return "Fill up the fields properly"
        }


        return ""
    }
}
