package com.example.noteapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.classes.Notes


class NoteAdapter(val notelist : ArrayList<Notes>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {


    class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notename = itemView.findViewById<TextView>(R.id.recycler_note_name)
        val noteContent = itemView.findViewById<TextView>(R.id.recycler_note_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_list,parent,false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int {
        return notelist.count()
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val note : Notes = notelist[position]
        holder.notename.text = note.noteName
        holder.noteContent.text = note.noteContent
    }

}