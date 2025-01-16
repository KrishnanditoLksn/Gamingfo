package app.ditsdev.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val gameId: Int,
    val gameName: String,
    val descriptionGame: String,
    val backgroundImage: String,
    val released: String,
    val rating: String,
    val isFavorite:Boolean
) : Parcelable