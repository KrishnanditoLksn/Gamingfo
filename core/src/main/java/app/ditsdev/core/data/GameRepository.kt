package app.ditsdev.core.data

import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.data.source.remote.network.responses.GamesItemResponse
import app.ditsdev.core.data.source.local.LocalGameDataSource
import app.ditsdev.core.data.source.remote.RemoteGameDataSource
import app.ditsdev.core.domain.repository.game.ImplGameRepository
import app.ditsdev.core.data.resources.NetworkBoundResources
import app.ditsdev.core.data.result.api.ApiResponseResult
import app.ditsdev.core.data.result.resource.ResourceResult
import app.ditsdev.core.utils.AppExecutor
import app.ditsdev.core.utils.DataMapper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class GameRepository(
    private val appExecutor: AppExecutor,
    private val remoteGameDataSource: RemoteGameDataSource,
    private val localGameDataSource: LocalGameDataSource
) : ImplGameRepository {
    override fun getAllGames(): Flowable<ResourceResult<List<Game>>> {
        return object : NetworkBoundResources<List<Game>, List<GamesItemResponse>>(appExecutor) {
            override fun loadFromDB(): Flowable<List<Game>> {
                return localGameDataSource.getAllGames().map {
                    DataMapper.mapGameEntitiesToDomain(it)
                }
            }

            override fun createCall(): Flowable<ApiResponseResult<List<GamesItemResponse>>> {
                return remoteGameDataSource.getAllGames()
            }

            override fun saveCallResult(data: List<GamesItemResponse>) {
                localGameDataSource.insertGame(DataMapper.mapGameResponseToEntity(data))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }

            override fun shouldFetch(data: List<Game>?): Boolean {
                return data.isNullOrEmpty()
            }
        }.asFlowable()
    }


    override fun getFavoriteGames(): Flowable<List<Game>> {
        return localGameDataSource.getFavoriteGame().map {
            DataMapper.mapGameEntitiesToDomain(it)
        }
    }

    override fun setFavoriteGames(game: Game, state: Boolean) {
        return appExecutor.diskIO().execute {
            localGameDataSource.setFavoriteGame(
                game = DataMapper.mapGameDomainToEntities(game),
                state
            )
        }
    }

    override fun searchGames(params: String): Flowable<List<Game>> {
        return localGameDataSource.searchGames(params).map {
            DataMapper.mapGameEntitiesToDomain(it)
        }
    }
}
