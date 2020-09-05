package info.sanaebadi.data.entity.place.promoted

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class PromotedListEntity(
	@field:Json(name = "promotedPlaces")
	val places: MutableList<PromotedItemEntity?>? = null
) : BaseEntity

