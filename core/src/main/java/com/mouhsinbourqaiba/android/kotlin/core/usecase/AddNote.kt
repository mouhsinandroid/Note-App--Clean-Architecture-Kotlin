package com.mouhsinbourqaiba.android.kotlin.core.usecase

import com.mouhsinbourqaiba.android.kotlin.core.data.Note
import com.mouhsinbourqaiba.android.kotlin.core.repository.NoteRepository

class AddNote(private val noteRepository : NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)

}