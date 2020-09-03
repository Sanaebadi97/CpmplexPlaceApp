package info.sanaebadi.data.repository.dataSource.place

import info.sanaebadi.data.entity.place.PlaceEntity
import io.reactivex.Single

interface PlaceDataSource {
    fun getPlaces(): Single<List<PlaceEntity>>
}