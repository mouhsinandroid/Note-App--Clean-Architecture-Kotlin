package com.mouhsinbourqaiba.android.kotlin.mynotes.framework

import android.content.Context
import androidx.room.Database
import com.mouhsinbourqaiba.android.kotlin.core.data.Note
import com.mouhsinbourqaiba.android.kotlin.core.repository.NoteDataSource
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.db.DatabaseService
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.db.NoteEntity

class RoomNoteDataSource(context: Context) : NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun removeNote(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}