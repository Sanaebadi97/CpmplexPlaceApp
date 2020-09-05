package info.sanaebadi.data.repository.dataSource.place.promoted

import info.sanaebadi.data.mapper.place.promoted.PromotedMapper
import info.sanaebadi.data.repository.dataSource.place.places.PlaceDataSourceFactory
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.domain.repository.place.promoted.PromotedRepository
import io.reactivex.Single
import javax.inject.Inject

class PromotedDataRepository @Inject constructor(
    private val promoteDataSourceFactory: PlaceDataSourceFactory,
    private val promotedMapper: PromotedMapper
) : PromotedRepository {

    override fun getPromotedPlaces(): Single<PromotedListModel> {
        TODO("Not yet implemented")
    }


}