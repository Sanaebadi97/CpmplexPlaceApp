package info.sanaebadi.data.entity.place.places

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class PlaceListEntity(
	@field:Json(name = "places")
	val places: MutableList<PlacesItemEntity?>? = null
) : BaseEntity

