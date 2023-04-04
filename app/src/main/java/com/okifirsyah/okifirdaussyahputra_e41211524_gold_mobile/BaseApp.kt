package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile

import android.app.Application
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.di.localModule
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.di.noteModule
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApp)

            Timber.plant(Timber.DebugTree())

            modules(
                listOf(
                    localModule,
                    noteModule,
                    viewModelModule,
                )
            )
        }
    }

    companion object {
        val instance: BaseApp by lazy { BaseApp() }
    }
}