package info.sanaebadi.placeapp.mapper.place

import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.placeapp.mapper.base.PresentationLayerMapper
import info.sanaebadi.placeapp.model.place.PlaceListPresentation
import info.sanaebadi.placeapp.model.place.PlacesPresentationItem
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacePresentationsMapper @Inject constructor() :
    PresentationLayerMapper<PlacesPresentationItem, PlaceItem?> {

    override fun toDomain(p: PlacesPresentationItem): PlaceItem? {
        return null
    }

    fun mtoPresentation(placeListModel: PlaceListModel): PlaceListPresentation? {
        val itemPresentationList: MutableList<PlacesPresentationItem> =
            ArrayList<PlacesPresentationItem>()

        for (placesItem in placeListModel.places!!) {
            itemPresentationList.add(toPresentation(placesItem!!))
        }
        return PlaceListPresentation(itemPresentationList)
    }

    override fun toPresentation(data: PlaceItem?): PlacesPresentationItem {
        return PlacesPresentationItem(
            score = data?.score,
            shortAddress = data?.shortAddress,
            bannerUrl = data?.bannerUrl,
            description = data?.description,
            id = data?.id,
            iconUrl = data?.iconUrl
        )
    }


}