package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.sqlite_room.main_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Note
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.repository.NoteRepository

class MainRoomViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    fun getAllNotes(): LiveData<List<Note>> = noteRepository.getAllNotes()
}