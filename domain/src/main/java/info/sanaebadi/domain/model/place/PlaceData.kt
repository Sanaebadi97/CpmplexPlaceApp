package info.sanaebadi.domain.model.place

import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem

data class PlaceData(
    val promotedList: List<PromotedItem>,
    val places: List<PlaceItem>,
    val favoriteIds: FavoriteListItem
) : ViewType {
    override fun getViewType(): Int {
        TODO("Not yet implemented")
    }
}