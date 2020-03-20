package com.mouhsinbourqaiba.android.kotlin.core.repository

import com.mouhsinbourqaiba.android.kotlin.core.data.Note

class NoteRepository(private val dataSource: NoteDataSource) {
    suspend fun addNote(note: Note) = dataSource.add(note)
    suspend fun getNote(id: Long) = dataSource.get(id)
    suspend fun getAllNotes()= dataSource.getAll()
    suspend fun removeNote(note: Note) = dataSource.removeNote(note)
}