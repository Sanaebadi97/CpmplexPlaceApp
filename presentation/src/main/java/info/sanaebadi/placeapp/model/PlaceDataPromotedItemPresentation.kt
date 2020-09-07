package info.sanaebadi.placeapp.model

import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.placeapp.model.places.PlaceListModelPresentation
import info.sanaebadi.placeapp.model.promoted.PromotedListModelPresentation

data class PlaceDataPromotedItemPresentation(
    val promotedListPromotedItemPresentation: PromotedListModelPresentation? = null,
    val placesPromotedItemPresentation: PlaceListModelPresentation? = null,
    val favoriteIdsPromotedItemPresentation: FavoriteListItem? = null
)