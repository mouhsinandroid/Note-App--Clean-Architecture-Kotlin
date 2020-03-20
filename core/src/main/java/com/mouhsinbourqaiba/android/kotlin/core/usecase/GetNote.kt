package com.mouhsinbourqaiba.android.kotlin.core.usecase

import com.mouhsinbourqaiba.android.kotlin.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id:Long) = noteRepository.getNote(id)
}