package com.mouhsinbourqaiba.android.kotlin.core.usecase

import com.mouhsinbourqaiba.android.kotlin.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {
    suspend operator fun invoke()= noteRepository.getAllNotes()
}