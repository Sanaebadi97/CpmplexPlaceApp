package info.sanaebadi.domain.model.place.places

import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.domain.model.base.ViewType

data class PlaceListModel(
    val places: List<PlaceItem>? = null
) : BaseDomainModel

data class PlaceItem(
    val score: Double? = null,
    val shortAddress: String? = null,
    val bannerUrl: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val iconUrl: String? = null,
    val title: String? = null
) : BaseDomainModel, ViewType {
    override fun getViewType(): Int = 2
}


