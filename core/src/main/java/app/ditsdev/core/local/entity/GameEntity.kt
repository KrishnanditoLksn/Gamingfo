package app.ditsdev.core.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "gameId")
    val gameId: Int,

    @ColumnInfo(name = "gameName")
    val gameName: String,

    @ColumnInfo(name = "rating")
    val rating: String,

    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String,

    @ColumnInfo(name = "released")
    val released: String,


    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean = false

)
