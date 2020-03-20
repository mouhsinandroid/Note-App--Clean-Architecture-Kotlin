package com.mouhsinbourqaiba.android.kotlin.mynotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mouhsinbourqaiba.android.kotlin.core.data.Note
import com.mouhsinbourqaiba.android.kotlin.core.repository.NoteRepository
import com.mouhsinbourqaiba.android.kotlin.core.usecase.AddNote
import com.mouhsinbourqaiba.android.kotlin.core.usecase.GetAllNotes
import com.mouhsinbourqaiba.android.kotlin.core.usecase.GetNote
import com.mouhsinbourqaiba.android.kotlin.core.usecase.RemoveNote
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.di.ApplicationModule
import com.mouhsinbourqaiba.android.kotlin.mynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel(application: Application): AndroidViewModel(application){
    private val coroutineScoupe = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }
    val save = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()

    fun saveNote(note: Note){
        coroutineScoupe.launch {
            useCases.addNote(note)
            save.postValue(true)
        }
    }

    fun getNote(id : Long){
        coroutineScoupe.launch {
            val note = useCases.getNote(id)
            currentNote.postValue(note)
        }
    }

    fun deleteNote(note: Note){
        coroutineScoupe.launch {
            useCases.removeNote(note)
            save.postValue(true)
        }
    }
}