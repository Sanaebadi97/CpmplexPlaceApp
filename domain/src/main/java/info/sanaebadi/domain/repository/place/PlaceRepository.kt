package info.sanaebadi.domain.repository.place

import info.sanaebadi.domain.model.place.PlaceListModel
import io.reactivex.Single

interface PlaceRepository {
    fun getPlaces(): Single<PlaceListModel>
}