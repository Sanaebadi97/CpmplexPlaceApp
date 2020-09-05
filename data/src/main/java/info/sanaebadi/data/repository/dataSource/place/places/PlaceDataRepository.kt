package info.sanaebadi.data.repository.dataSource.place.places

import info.sanaebadi.data.mapper.place.places.PlaceDataMapper
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.domain.repository.place.places.PlaceRepository
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
