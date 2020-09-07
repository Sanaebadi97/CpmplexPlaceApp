package info.sanaebadi.placeapp.model

import info.sanaebadi.domain.model.place.favorite.FavoriteListItem

data class PlaceDataModel(
    val promotedList: List<Promote>,
    val places: List<Places>,
    val favoriteIds: FavoriteListItem
)