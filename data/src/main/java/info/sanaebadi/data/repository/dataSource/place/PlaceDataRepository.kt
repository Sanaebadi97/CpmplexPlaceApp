package info.sanaebadi.data.repository.dataSource.place

import info.sanaebadi.data.mapper.place.PlaceDataMapper
import info.sanaebadi.domain.model.place.PlaceListModel
import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.domain.repository.place.PlaceRepository
import io.reactivex.Single
import javax.inject.Inject

class PlaceDataRepository @Inject constructor(
    private val placeDataSourceFactory: PlaceDataSourceFactory,
    private val placeDataMapper: PlaceDataMapper
) : PlaceRepository {

    override fun getPlaces(): Single<PlaceListModel> {
        return placeDataSourceFactory.create(CacheStrategy.ONLINE_FIRST)
            .getPlaces()
            .map { data -> placeDataMapper.toDomain(data) }
    }
}
