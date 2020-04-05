package com.example.noteapp.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.adapters.NoteAdapter
import com.example.noteapp.classes.Notes

class AllNotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_notes)
        val recyclerView = findViewById<RecyclerView>(R.id.note_recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val notes = ArrayList<Notes>()
        notes.add(Notes("Hi","Here I am"))
        notes.add(Notes("Hi","Here I am"))
        notes.add(Notes("Hi","Here I am"))
        notes.add(Notes("Hi","Here I am"))
        notes.add(Notes("Hi","Here I am"))
        val adapter = NoteAdapter(notes)
        recyclerView.adapter = adapter
    }
}
