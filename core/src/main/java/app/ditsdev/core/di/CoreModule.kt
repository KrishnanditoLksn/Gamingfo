package app.ditsdev.core.di

import androidx.room.Room
import app.ditsdev.core.BuildConfig
import app.ditsdev.core.local.database.GameDatabase
import app.ditsdev.core.remote.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CoreModule {

    val networkModule = module {
        single {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        }

        single {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(get())
                .build()
            retrofit.create(ApiService::class.java)
        }
    }

    val databaseModule = module {
//        factory { get(<GameDatabase>) }
        single {
            Room.databaseBuilder(
                androidContext(),
                GameDatabase::class.java, "Gamingfo.db"
            ).fallbackToDestructiveMigration().build()
        }
    }
}