package info.sanaebadi.domain.interactor.place

import info.sanaebadi.domain.model.place.PlaceData
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import io.reactivex.Single
import javax.inject.Inject

class PlaceUseCase @Inject constructor(private val placeRepository: PlaceRepository) {

    fun execute(): Single<PlaceData> {
        return Single.zip(
            placeRepository.getPromoted(),
            placeRepository.getPlaces(),
            placeRepository.getFavorites(),
            { promoted, places, favorites ->
                createPlaceDataModel(promoted.promotedList!!, places.places!!, favorites)
            })
    }


    private fun createPlaceDataModel(
        promotedItems: List<PromotedItem>,
        placeItems: List<PlaceItem>,
        favoriteListItem: FavoriteListItem,
    ): PlaceData {
        val promotedModel = promotedItems
        val placesModel = placeItems
        val favoriteModel = favoriteListItem

        return PlaceData(promotedModel, placesModel, favoriteModel)
    }
}