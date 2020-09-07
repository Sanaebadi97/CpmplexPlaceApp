package info.sanaebadi.placeapp.mocks.model.repositories

import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import io.reactivex.Single
import io.reactivex.SingleEmitter

class FakePlaceRepository : PlaceRepository {

    private fun <T> createSingle(emittedItem: T): Single<T> {
        return Single.create { emitter: SingleEmitter<T> -> emitter.onSuccess(emittedItem) }
    }

    override fun getPromoted(): Single<PromotedListModel> {
        TODO("Not yet implemented")
    }

    override fun getPlaces(): Single<PlaceListModel> {
        TODO("Not yet implemented")
    }

    override fun getFavorites(): Single<FavoriteListItem> {
        return createSingle(emptyList())
    }
}