package info.sanaebadi.data.mapper.place.places

import info.sanaebadi.data.entity.place.places.PlaceListEntity
import info.sanaebadi.data.entity.place.places.PlacesItemEntity
import info.sanaebadi.data.mapper.base.DataLayerMapper
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.places.PlaceListModel
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceDataMapper @Inject constructor() : DataLayerMapper<PlacesItemEntity, PlaceItem> {


     fun toDomain(placeListEntity: PlaceListEntity): PlaceListModel? {
        val placeList: MutableList<PlaceItem> = ArrayList<PlaceItem>()

        for (placeItem in placeListEntity.places!!) {
            placeList.add(toDomain(placeItem))
        }

        return PlaceListModel(placeList)
    }


    override fun toDomain(data: PlacesItemEntity?): PlaceItem {
        return PlaceItem(
            score = data?.score,
            shortAddress = data?.shortAddress,
            bannerUrl = data?.bannerUrl,
            description = data?.description,
            id = data?.id,
            iconUrl = data?.iconUrl,
            title = data?.title
        )
    }

    override fun toEntity(d: PlaceItem?): PlacesItemEntity? {
        return null
    }


}