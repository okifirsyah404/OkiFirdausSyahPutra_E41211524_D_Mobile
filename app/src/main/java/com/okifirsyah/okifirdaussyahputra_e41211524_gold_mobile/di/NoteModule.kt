package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.di

import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.repository.NoteRepository
import org.koin.dsl.module

var noteModule = module {
    single { NoteRepository(get()) }
}