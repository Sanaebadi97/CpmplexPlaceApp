package info.sanaebadi.domain.model.place

import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.domain.model.place.promoted.PromotedListModel

data class PlaceData(
    val promotedList: PromotedListModel? = null,
    val places: PlaceListModel? = null,
    val favoriteIds: FavoriteListItem? = null
) : BaseDomainModel