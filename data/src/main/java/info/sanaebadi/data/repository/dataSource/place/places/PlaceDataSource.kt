package info.sanaebadi.data.repository.dataSource.place.places

import info.sanaebadi.data.entity.place.places.PlaceListEntity
import io.reactivex.Single

interface PlaceDataSource {
    fun getPlaces(): Single<PlaceListEntity>
}