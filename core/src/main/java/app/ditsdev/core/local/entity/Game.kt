package app.ditsdev.core.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "gameId")
    val gameId: Int,

    @ColumnInfo(name = "gameName")
    val gameName: String,

    @ColumnInfo(name = "descriptionGame")
    val descriptionGame: String,

    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String,

    @ColumnInfo(name = "released")
    val released: String,

    @ColumnInfo(name = "rating")
    val rating: String,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean

)
