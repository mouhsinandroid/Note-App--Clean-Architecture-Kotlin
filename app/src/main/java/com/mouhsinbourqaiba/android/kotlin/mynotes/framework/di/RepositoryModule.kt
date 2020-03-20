package com.mouhsinbourqaiba.android.kotlin.mynotes.framework.di

import android.app.Application
import com.mouhsinbourqaiba.android.kotlin.core.repository.NoteRepository
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesRepository(app:Application) = NoteRepository(RoomNoteDataSource(app))
}