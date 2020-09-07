package info.sanaebadi.data.mapper.place.places

import info.sanaebadi.data.entity.place.promoted.PromotedItemEntity
import info.sanaebadi.data.entity.place.promoted.PromotedListEntity
import info.sanaebadi.data.mapper.base.DataLayerMapper
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import java.util.*
import javax.inject.Inject

class PromotedMapper @Inject constructor() : DataLayerMapper<PromotedItemEntity, PromotedItem> {


    fun toDomain(promoListEntity: PromotedListEntity): PromotedListModel? {
        val promotedList: MutableList<PromotedItem>? = ArrayList<PromotedItem>()

        for (promotedItem in promoListEntity.places!!) {
            promotedList?.add(toDomain(promotedItem))
        }

        return PromotedListModel(promotedList)
    }

    override fun toDomain(data: PromotedItemEntity?): PromotedItem {
        return PromotedItem(
            score = data?.score,
            shortAddress = data?.shortAddress,
            bannerUrl = data?.bannerUrl,
            description = data?.description,
            id = data?.id,
            iconUrl = data?.iconUrl,
            title = data?.title
        )
    }

    override fun toEntity(d: PromotedItem?): PromotedItemEntity? {
        return null
    }
}