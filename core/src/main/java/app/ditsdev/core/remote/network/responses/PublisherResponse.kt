package app.ditsdev.core.remote.network.responses

import com.google.gson.annotations.SerializedName

data class PublisherResponse(

    @field:SerializedName("next")
    val next: String? = null,

    @field:SerializedName("previous")
    val previous: Any? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("results")
    val results: List<ResultsItem> = emptyList()
)

data class PublisherGamesItem(

    @field:SerializedName("added")
    val added: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("slug")
    val slug: String? = null
)

data class ResultsItem(

    @field:SerializedName("games_count")
    val gamesCount: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("games")
    val games: List<PublisherGamesItem?>? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("image_background")
    val imageBackground: String? = null,

    @field:SerializedName("slug")
    val slug: String? = null
)
