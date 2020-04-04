package com.example.noteapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            //TODO: implement saving functionality
        }
    }
}
