package app.ditsdev.core.di

import androidx.room.Room
import app.ditsdev.core.BuildConfig
import app.ditsdev.core.domain.interactor.GameInteractor
import app.ditsdev.core.domain.interactor.PublisherInteractor
import app.ditsdev.core.data.GameRepository
import app.ditsdev.core.domain.repository.game.ImplGameRepository
import app.ditsdev.core.domain.repository.publisher.ImplPublisherRepository
import app.ditsdev.core.data.PublisherRepository
import app.ditsdev.core.domain.usecase.GameUseCase
import app.ditsdev.core.domain.usecase.PublisherUseCase
import app.ditsdev.core.data.source.local.database.GameDatabase
import app.ditsdev.core.data.source.remote.network.ApiService
import app.ditsdev.core.data.source.local.LocalGameDataSource
import app.ditsdev.core.data.source.remote.RemoteGameDataSource
import app.ditsdev.core.data.source.local.LocalPublisherDataSource
import app.ditsdev.core.data.source.remote.RemotePublisherDataSource
import app.ditsdev.core.utils.AppExecutor
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CoreModule {

    val networkModule = module {
        single {
            val hostname = "api.rawg.io"
            val certificatePinner = CertificatePinner.Builder()
                .add(hostname, "sha256/eerOFGv587fGOb2Cx6CD4S+MfehEojzU5nwhF4xx4/0=")
                .add(hostname, "sha256/kIdp6NNEd8wsugYyyIYFsi1ylMCED3hZbSR8ZFsa/A4=")
                .add(hostname, "sha256/mEflZT5enoR1FuXLgYYGqnVEoZvmf9c2bVBpiOjYQ0c=")
                .build()
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .certificatePinner(certificatePinner)
                .build()
        }

        single {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(get())
                .build()
            retrofit.create(ApiService::class.java)
        }
    }

    val databaseModule = module {
        factory { get<GameDatabase>().gameDao() }
        factory { get<GameDatabase>().publisherDao() }
        single {
            val passPhrase: ByteArray = SQLiteDatabase.getBytes("ditsdev".toCharArray())
            val factory = SupportFactory(passPhrase)
            Room.databaseBuilder(
                androidContext(),
                GameDatabase::class.java, "Gamingfo.db"
            ).fallbackToDestructiveMigration()
                .openHelperFactory(factory)
                .build()
        }
    }

    val repositoryModule = module {
        single { RemoteGameDataSource(get()) }
        single { LocalGameDataSource(get()) }
        factory { AppExecutor() }
        single<ImplGameRepository> { GameRepository(get(), get(), get()) }
    }

    val publisherRepositoryModule = module {
        single { RemotePublisherDataSource(get()) }
        single { LocalPublisherDataSource(get()) }
        factory { AppExecutor() }
        single<ImplPublisherRepository> { PublisherRepository(get(), get(), get()) }
    }

    val useCaseModule = module {
        factory<GameUseCase> { GameInteractor(get()) }
        factory<PublisherUseCase> { PublisherInteractor(get()) }
    }
}