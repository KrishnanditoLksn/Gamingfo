package app.ditsdev.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Publisher(
    val idPublisher: Int,
    val name: String,
    val imageBackground: String
) : Parcelable
