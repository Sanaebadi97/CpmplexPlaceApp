package info.sanaebadi.domain.interactor.place

import info.sanaebadi.domain.model.place.PlaceData
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import io.reactivex.Single
import io.reactivex.functions.Function3
import javax.inject.Inject

class PlaceUseCase @Inject constructor(private val placeRepository: PlaceRepository) {

    fun execute(): Single<PlaceData> {
        return Single.zip(
            placeRepository.getPromoted(),
            placeRepository.getPlaces(),
            placeRepository.getFavorites(),
            Function3<PromotedListModel, PlaceListModel, FavoriteListItem, PlaceData> { promoted, places, favorite ->
                createPlaceDataModel(promoted, places, favorite)
            })
    }


    private fun createPlaceDataModel(
        promotedItems: PromotedListModel,
        placeItems: PlaceListModel,
        favoriteListItem: FavoriteListItem,
    ): PlaceData {
        val promotedModel = promotedItems
        val placesModel = placeItems
        val favoriteModel = favoriteListItem

        return PlaceData(promotedModel, placesModel, favoriteModel)
    }
}