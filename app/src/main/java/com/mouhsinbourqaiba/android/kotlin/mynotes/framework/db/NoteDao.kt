package com.mouhsinbourqaiba.android.kotlin.mynotes.framework.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface NoteDao {

    @Insert(onConflict = REPLACE)
    suspend fun addNoteEntity(noteEntity: NoteEntity)

    @Query("SELECT * FROM note WHERE id= :id " )
    suspend fun getNoteEntity(id:Long) : NoteEntity?

    @Query("SELECT * FROM note")
    suspend fun getAllNoteEntities(): List<NoteEntity>

    @Delete
    suspend fun deleteNoteEntity(note:NoteEntity)
}