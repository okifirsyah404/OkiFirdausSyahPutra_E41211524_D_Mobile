package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.repository

import androidx.lifecycle.LiveData
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.local.dao.NoteDao
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Note

class NoteRepository(private val notesDao: NoteDao) {

    fun getAllNotes(): LiveData<List<Note>> = notesDao.getAllNotes()

    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    suspend fun delete(note: Note) {
        notesDao.delete(note)
    }

    suspend fun update(note: Note) {
        notesDao.update(note)
    }
}