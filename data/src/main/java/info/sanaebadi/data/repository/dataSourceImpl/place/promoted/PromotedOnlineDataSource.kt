package info.sanaebadi.data.repository.dataSourceImpl.place.promoted

import info.sanaebadi.data.entity.place.promoted.PromotedListEntity
import info.sanaebadi.data.networking.base.AbstractService
import info.sanaebadi.data.networking.retrofit.PromotedApiRetrofitService
import info.sanaebadi.data.repository.dataSource.place.promoted.PromotedDataSource
import io.reactivex.Single

class PromotedOnlineDataSource :
    AbstractService<PromotedApiRetrofitService>(PromotedApiRetrofitService::class.java),
    PromotedDataSource {

    override fun getPromotedPlace(): Single<PromotedListEntity> {
        return service.getPromotedPlaces()
    }

}