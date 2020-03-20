package com.mouhsinbourqaiba.android.kotlin.core.usecase

import com.mouhsinbourqaiba.android.kotlin.core.data.Note

class GetWordCount {
    operator fun invoke(note:Note)= getCount(note.title)+ getCount(note.content)

    private fun getCount(str:String) =
         str.split(" ","\n")
             .filter {
                 it.contains(Regex(".*[azAZ].*"))
             }.count()
}