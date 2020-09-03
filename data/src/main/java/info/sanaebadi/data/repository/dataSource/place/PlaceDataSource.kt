package info.sanaebadi.data.repository.dataSource.place

import info.sanaebadi.data.entity.place.PlaceListEntity
import io.reactivex.Single

interface PlaceDataSource {
    fun getPlaces(): Single<PlaceListEntity>
}