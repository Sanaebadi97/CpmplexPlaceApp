package info.sanaebadi.data.repository.dataSource.place.promoted

import info.sanaebadi.data.repository.dataSource.base.BaseDataSourceFactory
import info.sanaebadi.data.repository.dataSourceImpl.place.promoted.PromotedOnlineDataSource
import info.sanaebadi.domain.repository.CacheStrategy
import io.reactivex.Completable
import javax.inject.Inject

class PromotedDataSourceFactory @Inject constructor() : BaseDataSourceFactory<PromotedDataSource> {

    override fun create(cacheStrategy: CacheStrategy?, vararg params: String?): PromotedDataSource {
        return PromotedOnlineDataSource()
    }

    override fun deleteCache(): Completable? {
      return null
    }

}