package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.sqlite_room.add_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Note
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteAddUpdateViewModel(private val mNoteRepository: NoteRepository) : ViewModel() {

    fun insert(note: Note) {
        viewModelScope.launch {
            mNoteRepository.insert(note)
        }

    }

    fun update(note: Note) {

        viewModelScope.launch {
            mNoteRepository.update(note)
        }
    }

    fun delete(note: Note) {
        viewModelScope.launch {
            mNoteRepository.delete(note)
        }
    }
}