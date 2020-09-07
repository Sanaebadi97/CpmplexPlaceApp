package info.sanaebadi.domain.model.place

import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceItemType
import info.sanaebadi.domain.model.place.promoted.PromotedItemType

data class PlaceData(
    val promotedList: List<PromotedItemType>,
    val places: List<PlaceItemType>,
    val favoriteIds: FavoriteListItem
)