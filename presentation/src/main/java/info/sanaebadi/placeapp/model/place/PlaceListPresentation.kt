package info.sanaebadi.placeapp.model.place

import info.sanaebadi.placeapp.model.base.PresentationModel

data class PlaceListPresentation(
    val places: List<PlacesPresentationItem?>? = null
) : PresentationModel

data class PlacesPresentationItem(
    val score: Double? = null,
    val shortAddress: String? = null,
    val bannerUrl: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val iconUrl: String? = null,
    val title: String? = null
) : PresentationModel