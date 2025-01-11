package app.ditsdev.gamingfo

import android.app.Application
import app.ditsdev.core.di.CoreModule
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    CoreModule.networkModule
                )
            )
        }
    }
}