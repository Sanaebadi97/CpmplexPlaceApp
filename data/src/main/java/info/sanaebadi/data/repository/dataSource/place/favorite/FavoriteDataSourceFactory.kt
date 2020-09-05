package info.sanaebadi.data.repository.dataSource.place.favorite

import info.sanaebadi.data.repository.dataSource.base.BaseDataSourceFactory
import info.sanaebadi.data.repository.dataSourceImpl.place.favorite.FavoriteOnlineDataSource
import info.sanaebadi.domain.repository.CacheStrategy
import io.reactivex.Completable
import javax.inject.Inject

class FavoriteDataSourceFactory @Inject constructor() : BaseDataSourceFactory<FavoriteDataSource> {

    override fun create(cacheStrategy: CacheStrategy?, vararg params: String?): FavoriteDataSource {
        return FavoriteOnlineDataSource()
    }

    override fun deleteCache(): Completable? {
        return null
    }

}