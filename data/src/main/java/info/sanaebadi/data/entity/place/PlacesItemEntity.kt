package info.sanaebadi.data.entity.place

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.data.entity.base.BaseEntity

@JsonClass(generateAdapter = true)
data class PlacesItemEntity(

    @field:Json(name = "score")
    val score: Double? = null,

    @field:Json(name = "shortAddress")
    val shortAddress: String? = null,

    @field:Json(name = "bannerUrl")
    val bannerUrl: String? = null,

    @field:Json(name = "description")
    val description: String? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "iconUrl")
    val iconUrl: String? = null,

    @field:Json(name = "title")
    val title: String? = null
) : BaseEntity