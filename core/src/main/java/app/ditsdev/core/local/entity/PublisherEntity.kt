package app.ditsdev.core.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PublisherEntity(
    @PrimaryKey
    @ColumnInfo(name = "idPublisher")
    val idPublisher: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "imageBackground")
    val imageBackground: String,
    )
