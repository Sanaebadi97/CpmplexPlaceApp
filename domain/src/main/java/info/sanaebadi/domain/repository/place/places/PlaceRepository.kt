package info.sanaebadi.domain.repository.place.places

import info.sanaebadi.domain.model.place.places.PlaceListModel
import io.reactivex.Single

interface PlaceRepository {
    fun getPlaces(): Single<PlaceListModel>
}