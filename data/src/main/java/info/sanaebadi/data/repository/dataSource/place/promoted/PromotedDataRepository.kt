package info.sanaebadi.data.repository.dataSource.place.promoted

import info.sanaebadi.data.mapper.place.promoted.PromotedMapper
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.domain.repository.place.promoted.PromotedRepository
import io.reactivex.Single
import javax.inject.Inject

class PromotedDataRepository @Inject constructor(
    private val promoteDataSourceFactory: PromotedDataSourceFactory,
    private val promotedMapper: PromotedMapper
) : PromotedRepository {

    override fun getPromotedPlaces(): Single<PromotedListModel> {
        return promoteDataSourceFactory.create(CacheStrategy.ONLINE_FIRST)
            .getPromotedPlace()
            .map { data -> promotedMapper.toDomain(data) }
    }


}