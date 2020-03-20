package com.mouhsinbourqaiba.android.kotlin.mynotes.framework

import com.mouhsinbourqaiba.android.kotlin.core.usecase.*

data class UseCases(
    val addNote: AddNote,
    val getNote: GetNote,
    val getAllNotes: GetAllNotes,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount
)