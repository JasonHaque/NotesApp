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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_notes)
        val recyclerView = findViewById<RecyclerView>(R.id.note_recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val notes = ArrayList<Notes>()
        val usermail = FirebaseAuth.getInstance().currentUser?.email.toString()
        val split =usermail.split("@")
        val user = split[0]
        print("Hello from here")
        db.child("Users").child(user).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("Error receiving data")
            }

            override fun onDataChange(p0: DataSnapshot) {

                if (p0.exists()){
                    val dataMap = p0.value as HashMap<String,Any>?
                    print(dataMap)
                    for (key in dataMap!!.keys){
                        val data = dataMap!![key]
                        val userdata =
                            data as HashMap<String, Any>?
                        print(userdata)
                        val abs = Notes(
                            userdata!!["noteName"] as String,
                            userdata["noteContent"] as String
                        )
                        notes.add(abs)


                    }
                }



            }

        })










        val adapter = NoteAdapter(notes)
        recyclerView.adapter = adapter
    }

}
