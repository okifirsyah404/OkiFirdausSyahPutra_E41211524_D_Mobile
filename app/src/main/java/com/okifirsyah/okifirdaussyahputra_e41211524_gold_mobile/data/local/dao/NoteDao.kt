package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from note ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}