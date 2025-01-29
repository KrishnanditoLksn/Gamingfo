package app.ditsdev.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.ditsdev.core.data.source.local.entity.PublisherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface PublisherDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPublishers(publisher: List<PublisherEntity>): Completable

    @Query("SELECT * FROM publishers")
    fun displayAllPublishers(): Flowable<List<PublisherEntity>>
}