package info.sanaebadi.data.repository.dataSource.place

import info.sanaebadi.domain.model.place.PlaceListModel
import info.sanaebadi.domain.repository.place.PlaceRepository
import io.reactivex.Single

class PlaceDataRepository :PlaceRepository {
    override fun getPlaces(): Single<List<PlaceListModel>> {
        TODO("Not yet implemented")
    }
}