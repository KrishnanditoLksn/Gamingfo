package app.ditsdev.core.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.ditsdev.core.local.dao.GameDao
import app.ditsdev.core.local.dao.PublisherDao
import app.ditsdev.core.local.entity.GameEntity
import app.ditsdev.core.local.entity.PublisherEntity


@Database(entities = [GameEntity::class, PublisherEntity::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
    abstract fun publisherDao():PublisherDao
}