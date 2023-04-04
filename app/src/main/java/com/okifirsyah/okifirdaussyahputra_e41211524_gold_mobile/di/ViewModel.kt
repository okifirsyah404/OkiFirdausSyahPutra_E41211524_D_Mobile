package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.di

import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.sqlite_room.add_edit.NoteAddUpdateViewModel
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.sqlite_room.main_view.MainRoomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { MainRoomViewModel(get()) }
    viewModel { NoteAddUpdateViewModel(get()) }
}