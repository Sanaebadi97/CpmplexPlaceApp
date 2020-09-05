package info.sanaebadi.data.repository.dataSource.place.promoted

import info.sanaebadi.data.entity.place.promoted.PromotedListEntity
import io.reactivex.Single

interface PromotedDataSource {
    fun getPromotedPlace(): Single<PromotedListEntity>
}