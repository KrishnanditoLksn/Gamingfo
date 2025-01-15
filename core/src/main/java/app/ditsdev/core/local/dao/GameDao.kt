package app.ditsdev.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.ditsdev.core.local.entity.GameEntity
import app.ditsdev.core.local.entity.PublisherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGame(game: List<GameEntity>): Completable

    @Query("SELECT * FROM games")
    fun getAllGames(): Flowable<List<GameEntity>>

    @Query("SELECT * FROM games WHERE isFavorite = 1")
    fun getFavoriteGames(): Flowable<List<GameEntity>>

    @Query("SELECT gameName,descriptionGame,released,rating FROM games WHERE gameId =:id")
    fun getGameDetail(id: String): Flowable<GameEntity>


    @Query("SELECT * FROM publishers")
    fun getAllPublishers(): Flowable<List<PublisherEntity>>


    //TBA PUB DETAILS:
}