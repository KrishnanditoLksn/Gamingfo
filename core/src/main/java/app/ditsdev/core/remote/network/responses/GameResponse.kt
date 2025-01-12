package app.ditsdev.core.remote.network.responses

import com.google.gson.annotations.SerializedName

data class GameResponse(

    @field:SerializedName("next")
    val next: String? = null,

    @field:SerializedName("previous")
    val previous: String? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("results")
    val results: List<GameResultsItem?>? = null
)

data class Requirements(

    @field:SerializedName("minimum")
    val minimum: String? = null,

    @field:SerializedName("recommended")
    val recommended: String? = null
)

data class Platform(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("slug")
    val slug: String? = null
)

data class EsrbRating(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("slug")
    val slug: String? = null
)

data class PlatformsItem(

    @field:SerializedName("requirements")
    val requirements: Requirements? = null,

    @field:SerializedName("released_at")
    val releasedAt: String? = null,

    @field:SerializedName("platform")
    val platform: Platform? = null
)

data class AddedByStatus(
    val any: Any? = null
)

data class GameResultsItem(

    @field:SerializedName("added")
    val added: Int? = null,

    @field:SerializedName("suggestions_count")
    val suggestionsCount: Int? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("metacritic")
    val metacritic: Int? = null,

    @field:SerializedName("playtime")
    val playtime: Int? = null,

    @field:SerializedName("platforms")
    val platforms: List<PlatformsItem?>? = null,

    @field:SerializedName("background_image")
    val backgroundImage: String? = null,

    @field:SerializedName("tba")
    val tba: Boolean? = null,

    @field:SerializedName("esrb_rating")
    val esrbRating: EsrbRating? = null,

    @field:SerializedName("rating_top")
    val ratingTop: Int? = null,

    @field:SerializedName("reviews_text_count")
    val reviewsTextCount: String? = null,

    @field:SerializedName("ratings")
    val ratings: Ratings? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("added_by_status")
    val addedByStatus: AddedByStatus? = null,

    @field:SerializedName("ratings_count")
    val ratingsCount: Int? = null,

    @field:SerializedName("updated")
    val updated: String? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("released")
    val released: String? = null
)

data class Ratings(
    val any: String? = null
)
