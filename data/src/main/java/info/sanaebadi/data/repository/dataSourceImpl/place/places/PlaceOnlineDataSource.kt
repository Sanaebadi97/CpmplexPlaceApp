package info.sanaebadi.data.repository.dataSourceImpl.place.places

import info.sanaebadi.data.entity.place.places.PlaceListEntity
import info.sanaebadi.data.networking.base.AbstractService
import info.sanaebadi.data.networking.retrofit.PlaceApiRetrofitService
import info.sanaebadi.data.repository.dataSource.place.places.PlaceDataSource
import io.reactivex.Single

class PlaceOnlineDataSource :
    AbstractService<PlaceApiRetrofitService>(PlaceApiRetrofitService::class.java), PlaceDataSource {

    override fun getPlaces(): Single<PlaceListEntity> {
        return service.getPlaces()
    }

}