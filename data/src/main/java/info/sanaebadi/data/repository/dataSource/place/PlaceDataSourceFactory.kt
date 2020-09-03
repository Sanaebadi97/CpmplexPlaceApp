package info.sanaebadi.data.repository.dataSource.place

import info.sanaebadi.data.repository.dataSource.base.BaseDataSourceFactory
import info.sanaebadi.data.repository.dataSourceImpl.place.PlaceOnlineDataSource
import io.reactivex.Completable
import okhttp3.internal.cache.CacheStrategy

class PlaceDataSourceFactory : BaseDataSourceFactory<PlaceDataSource> {

    override fun create(cacheStrategy: CacheStrategy?, vararg params: String?): PlaceDataSource {
        return PlaceOnlineDataSource()
    }

    override fun deleteCache(): Completable? {
        return null
    }
}