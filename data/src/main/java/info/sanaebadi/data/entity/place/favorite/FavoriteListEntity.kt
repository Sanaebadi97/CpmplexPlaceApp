package info.sanaebadi.data.entity.place.favorite

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity


@JsonClass(generateAdapter = true)
data class FavoriteEntity(
	@Json(name = "favoriteIds")
	val favoriteIds: List<Int>? = null
):BaseEntity

