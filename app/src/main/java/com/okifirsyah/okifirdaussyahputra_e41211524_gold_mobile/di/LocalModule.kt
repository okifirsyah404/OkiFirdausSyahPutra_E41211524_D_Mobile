package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.di

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.local.room.LocalDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

    factory { get<LocalDatabase>().getNoteDao() }

    fun provideDatabase(application: Application): LocalDatabase {
        Log.d("LocalModule", "provideDatabase: ")
        return Room.databaseBuilder(application, LocalDatabase::class.java, "local_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { provideDatabase(androidApplication()) }
}