package info.sanaebadi.data.mapper.place.promoted

import info.sanaebadi.data.entity.place.places.PlacesItemEntity
import info.sanaebadi.data.entity.place.promoted.PromotedListEntity
import info.sanaebadi.data.mapper.base.DataLayerMapper
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import java.util.*
import javax.inject.Inject

class PromotedMapper @Inject constructor() : DataLayerMapper<PlacesItemEntity, PlaceItem> {


    fun toDomain(promoListEntity: PromotedListEntity): PromotedListModel? {
        val promotedList: MutableList<PlaceItem?> = ArrayList<PlaceItem?>()

        for (placeItem in promoListEntity.places!!) {
            promotedList.add(toDomain(placeItem))
        }

        return PromotedListModel(promotedList)
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