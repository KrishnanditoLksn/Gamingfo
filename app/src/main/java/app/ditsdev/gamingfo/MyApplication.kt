package app.ditsdev.gamingfo

import android.app.Application
import app.ditsdev.core.di.CoreModule
import app.ditsdev.gamingfo.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            loadKoinModules(
                listOf(
                    CoreModule.networkModule,
                    CoreModule.databaseModule,
                    CoreModule.repositoryModule,
                    CoreModule.useCaseModule,
                    AppModule.viewModelModule,
                )
            )
        }
    }
}