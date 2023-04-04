package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.local.dao.NoteDao
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Note

@Database(
    entities = [
        Note::class
    ],
    version = 2,
    exportSchema = false
)


abstract class LocalDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

}