package com.example.noteapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp.R
import kotlinx.android.synthetic.main.activity_home_view.*

class HomeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_view)
        bindListeners()
    }

    private fun bindListeners(){
        new_note_page.setOnClickListener {

        }
    }
}
