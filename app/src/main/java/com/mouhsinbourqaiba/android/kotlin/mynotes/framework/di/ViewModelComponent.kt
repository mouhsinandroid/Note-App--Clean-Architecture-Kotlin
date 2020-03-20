package com.mouhsinbourqaiba.android.kotlin.mynotes.framework.di

import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.ListViewModel
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class , RepositoryModule::class, UsesCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}