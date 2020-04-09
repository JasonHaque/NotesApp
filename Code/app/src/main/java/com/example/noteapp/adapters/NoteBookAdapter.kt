package com.example.noteapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.classes.NoteBook
import com.example.noteapp.classes.Notes

class NoteBookAdapter (val noteBookList : ArrayList<NoteBook>): RecyclerView.Adapter<NoteBookAdapter.NoteBookHolder>(){

    class NoteBookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteBookname = itemView.findViewById<TextView>(R.id.recycler_note_book_name)
        val author  = itemView.findViewById<TextView>(R.id.recycler_author_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteBookHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notebooks,parent,false)
        return NoteBookAdapter.NoteBookHolder(view)
    }

    override fun getItemCount(): Int {
        return noteBookList.count()
    }

    override fun onBindViewHolder(holder: NoteBookHolder, position: Int) {
        val note : NoteBook = noteBookList[position]
        holder.noteBookname.text = note.noteBookName
        holder.author.text = note.author
    }
}