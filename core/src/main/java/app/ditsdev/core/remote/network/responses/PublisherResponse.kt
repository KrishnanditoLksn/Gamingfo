package app.ditsdev.core.remote.network.responses

import com.google.gson.annotations.SerializedName

data class PublisherResponse(

    @field:SerializedName("next")
    val next: String? = null,

    @field:SerializedName("previous")
    val previous: String? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("results")
    val results: List<PublisherResultsItem?>? = null
)

data class PublisherResultsItem(

    @field:SerializedName("games_count")
    val gamesCount: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("image_background")
    val imageBackground: String? = null,
)
