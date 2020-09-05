package info.sanaebadi.data.entity.place.promoted

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity
import info.sanaebadi.data.entity.place.places.PlacesItemEntity

@JsonClass(generateAdapter = true)
data class PromotedListEntity(
	@field:Json(name = "promotedPlaces")
	val places: MutableList<PlacesItemEntity?>? = null
) : BaseEntity

