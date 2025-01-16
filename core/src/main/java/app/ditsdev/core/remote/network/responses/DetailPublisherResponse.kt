package app.ditsdev.core.remote.network.responses

import com.google.gson.annotations.SerializedName

data class DetailPublisherResponse(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("games_count")
	val gamesCount: Int? = null,

	@field:SerializedName("image_background")
	val imageBackground: String? = null,

	@field:SerializedName("description")
	val description: String? = null


)
