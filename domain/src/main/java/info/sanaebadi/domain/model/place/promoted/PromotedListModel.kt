package info.sanaebadi.domain.model.place.promoted

import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.domain.model.place.places.PlaceItem

data class PromotedListModel(
	val promotedList: MutableList<PlaceItem?>? = null
) : BaseDomainModel

