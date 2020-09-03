package info.sanaebadi.domain.model.place

import info.sanaebadi.domain.model.base.BaseDomainModel

data class PlaceModel(
    val places: List<PlacesItem?>? = null
) : BaseDomainModel

data class PlacesItem(
    val score: Double? = null,
    val shortAddress: String? = null,
    val bannerUrl: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val iconUrl: String? = null,
    val title: String? = null
)
