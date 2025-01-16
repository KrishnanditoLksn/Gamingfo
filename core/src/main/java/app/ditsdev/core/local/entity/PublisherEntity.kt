package app.ditsdev.core.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "publishers")
data class PublisherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idPublisher")
    val idPublisher: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "imageBackground")
    val imageBackground: String,
)
