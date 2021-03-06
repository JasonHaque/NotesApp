package com.example.noteapp.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.noteapp.R
import kotlinx.android.synthetic.main.activity_notebook.*

class NotebookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebook)
        bindViews()
        bindListeners()
    }

    fun bindViews(){
        note_book_name.visibility = View.GONE
    }
    fun bindListeners(){
        create_notebook.setOnClickListener {
            if (note_book_name.visibility == View.GONE){
                note_book_name.visibility = View.VISIBLE
                create_notebook.text = "NEXT"
                return@setOnClickListener
            }

            val notebookName = note_book_name.text.toString()
            val intent = Intent(this,NewNoteActivity::class.java)
            intent.putExtra("NotebookName",notebookName)
            startActivity(intent)

        }
    }
}
