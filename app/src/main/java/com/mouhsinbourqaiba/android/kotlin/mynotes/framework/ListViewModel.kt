package com.mouhsinbourqaiba.android.kotlin.mynotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mouhsinbourqaiba.android.kotlin.core.data.Note
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.di.ApplicationModule
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(app:Application): AndroidViewModel(app) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var  useCases : UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach { it.wordCount = useCases.getWordCount.invoke(it) }
            notes.postValue(noteList)
        }
    }
}