package com.mouhsinbourqaiba.android.kotlin.mynotes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mouhsinbourqaiba.android.kotlin.core.data.Note
import com.mouhsinbourqaiba.android.kotlin.mynotes.R
import kotlinx.android.synthetic.main.item_note.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NoteListAdapter(var notes:ArrayList<Note> , val action: ListAction): RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    fun updateNotes(newNotes:List<Note>){
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
    )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    inner class NoteViewHolder(view : View): RecyclerView.ViewHolder(view){
        private val layout = view.noteLayout
        private val noteTitle = view.title
        private val noteContent = view.content
        private val noteDate = view.date
        private val noteWord = view.wordCount


        fun bind(note: Note){
            noteTitle.text = note.title
            noteContent.text = note.content

            val sdf = SimpleDateFormat("MMM dd , HH:mm:ss")
            val resultDate = Date(note.updateTime)
            noteDate.text = "Last update : ${sdf.format(resultDate)}"

            noteWord.text = "Words: ${note.wordCount}"

            layout.setOnClickListener{action.onClick(note.id)}

        }
    }


}