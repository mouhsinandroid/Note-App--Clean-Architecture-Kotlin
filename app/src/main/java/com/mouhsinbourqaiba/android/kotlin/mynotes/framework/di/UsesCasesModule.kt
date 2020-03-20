package com.mouhsinbourqaiba.android.kotlin.mynotes.framework.di

import com.mouhsinbourqaiba.android.kotlin.core.repository.NoteRepository
import com.mouhsinbourqaiba.android.kotlin.core.usecase.*
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UsesCasesModule {

    @Provides
    fun getUsesCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetNote(repository),
        GetAllNotes(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}