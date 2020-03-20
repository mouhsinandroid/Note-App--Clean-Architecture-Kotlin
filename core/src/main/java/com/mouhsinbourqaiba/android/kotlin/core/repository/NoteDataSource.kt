package com.mouhsinbourqaiba.android.kotlin.core.repository

import com.mouhsinbourqaiba.android.kotlin.core.data.Note

interface NoteDataSource {

    suspend fun add(note: Note)
    suspend fun get(id: Long): Note?
    suspend fun getAll():List<Note>
    suspend fun removeNote(note: Note)

}