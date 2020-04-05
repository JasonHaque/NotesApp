package com.example.noteapp.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.adapters.NoteAdapter
import com.example.noteapp.classes.Notes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class AllNotesActivity : AppCompatActivity() {
    private var db = FirebaseDatabase.getInstance().reference
    private val menu: MutableList<Notes> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_notes)
        val recyclerView = findViewById<RecyclerView>(R.id.note_recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val notes = ArrayList<Notes>()
        val usermail = FirebaseAuth.getInstance().currentUser?.email.toString()
        val split =usermail.split("@")
        val user = split[0]

        db.child("Users").child(user).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("Error receiving data")
            }

            override fun onDataChange(p0: DataSnapshot) {
                //menu.clear()
                //notes.clear()
                p0.children.mapNotNullTo(notes) { it.getValue<Notes>(Notes::class.java) }
                p0.children.mapNotNullTo(menu) { it.getValue<Notes>(Notes::class.java) }
                //println("Menu printed")
                //println(menu)
                //println("notes printed")
                //println(notes)
                val adapter = NoteAdapter(notes)
                recyclerView.adapter = adapter
            }

        })








        println("Menu printed")
        println(menu)
        println("notes printed")
        println(notes)

        val adapter = NoteAdapter(notes)
        //println(notes)
        //println(menu)
        recyclerView.adapter = adapter
    }

}
