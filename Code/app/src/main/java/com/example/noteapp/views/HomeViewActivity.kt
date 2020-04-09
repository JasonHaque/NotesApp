package com.example.noteapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.activites.AllNotesActivity
import com.example.noteapp.activites.NewNoteActivity
import com.example.noteapp.activites.NotebookActivity
import com.example.noteapp.adapters.NoteBookAdapter
import com.example.noteapp.classes.NoteBook
import com.example.noteapp.classes.Notes
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home_view.*

class HomeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_view)
        bindListeners()
        val recyclerView = findViewById<RecyclerView>(R.id.notebooks_recyclerview)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val noteBooks = ArrayList<NoteBook>()
        val usermail = FirebaseAuth.getInstance().currentUser?.email.toString()
        val split =usermail.split("@")
        val user = split[0]


        noteBooks.add(NoteBook("Notun Boi",user))
        noteBooks.add(NoteBook("Puran Boi",user))
        noteBooks.add(NoteBook("kar Boi",user))
        noteBooks.add(NoteBook("Amar Boi",user))
        val adapter = NoteBookAdapter(noteBooks)
        recyclerView.adapter = adapter
    }

    private fun bindListeners(){
        add_notebook.setOnClickListener {
            val intent =Intent(this,NotebookActivity::class.java)
            startActivity(intent)
        }
        all_notes_page.setOnClickListener {
            val intent =Intent(this,AllNotesActivity::class.java)
            startActivity(intent)
        }
        profile_page.setOnClickListener {
            val intent =Intent(this,ProfileView::class.java)
            startActivity(intent)
        }
    }
}
