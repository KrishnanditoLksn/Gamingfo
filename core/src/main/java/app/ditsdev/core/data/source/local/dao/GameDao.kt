package app.ditsdev.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import app.ditsdev.core.data.source.local.entity.GameEntity
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

    @Update
    fun updateFavoriteGame(game: GameEntity)

    @Query("SELECT * FROM games WHERE gameName LIKE :params || '%' ")
    fun searchGames(params: String): Flowable<List<GameEntity>>
}