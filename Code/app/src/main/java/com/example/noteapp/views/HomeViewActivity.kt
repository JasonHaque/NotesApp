package com.example.noteapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp.R
import com.example.noteapp.activites.NewNoteActivity
import kotlinx.android.synthetic.main.activity_home_view.*

class HomeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_view)
        bindListeners()
    }

    private fun bindListeners(){
        new_note_page.setOnClickListener {
            val intent =Intent(this,NewNoteActivity::class.java)
            startActivity(intent)
        }
        profile_page.setOnClickListener {
            val intent =Intent(this,ProfileView::class.java)
            startActivity(intent)
        }
    }
}
