package info.sanaebadi.data.entity.place

import com.google.gson.annotations.SerializedName
import info.sanaebadi.data.entity.base.Entity

data class PlaceEntity(

	@field:SerializedName("places")
	val places: List<PlacesItem?>? = null
) : Entity

data class PlacesItem(

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("shortAddress")
	val shortAddress: String? = null,

	@field:SerializedName("bannerUrl")
	val bannerUrl: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("iconUrl")
	val iconUrl: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
