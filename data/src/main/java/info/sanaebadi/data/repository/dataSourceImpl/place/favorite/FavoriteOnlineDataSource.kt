package info.sanaebadi.data.repository.dataSourceImpl.place.favorite

import info.sanaebadi.data.entity.place.favorite.FavoriteEntity
import info.sanaebadi.data.networking.base.AbstractService
import info.sanaebadi.data.networking.retrofit.FavoriteApiRetrofitService
import info.sanaebadi.data.repository.dataSource.place.favorite.FavoriteDataSource
import io.reactivex.Single

class FavoriteOnlineDataSource :
    AbstractService<FavoriteApiRetrofitService>(FavoriteApiRetrofitService::class.java),
    FavoriteDataSource {

    override fun getFavorites(): Single<FavoriteEntity> {
        return service.getFavorites()
    }

}