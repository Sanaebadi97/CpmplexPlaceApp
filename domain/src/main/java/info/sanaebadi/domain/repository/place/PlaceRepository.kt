package info.sanaebadi.domain.repository.place

import info.sanaebadi.domain.model.place.PlaceModel
import io.reactivex.Single

interface PlaceRepository {
    fun getPlaces(): Single<List<PlaceModel>>
}