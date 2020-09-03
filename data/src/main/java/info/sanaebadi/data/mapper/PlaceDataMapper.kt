package info.sanaebadi.data.mapper

import info.sanaebadi.data.entity.place.PlacesItemEntity
import info.sanaebadi.data.mapper.base.DataLayerMapper
import info.sanaebadi.domain.model.place.PlacesItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceDataMapper @Inject constructor() : DataLayerMapper<PlacesItemEntity, PlacesItem> {

    override fun toDomain(data: PlacesItemEntity?): PlacesItem {
        return PlacesItem(
            score = data?.score,
            shortAddress = data?.shortAddress,
            bannerUrl = data?.bannerUrl,
            description = data?.description,
            id = data?.id,
            iconUrl = data?.iconUrl,
            title = data?.title
        )
    }

    override fun toEntity(d: PlacesItem?): PlacesItemEntity? {
        return null
    }


}