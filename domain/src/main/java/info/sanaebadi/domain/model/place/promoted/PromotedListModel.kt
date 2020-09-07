package info.sanaebadi.domain.model.place.promoted

import info.sanaebadi.domain.model.base.BaseDomainModel

data class PromotedListModel(
	val promotedList: MutableList<PromotedItem>? = null
) : BaseDomainModel

data class PromotedItem(
	val score: Double? = null,
	val shortAddress: String? = null,
	val bannerUrl: String? = null,
	val description: String? = null,
	val id: Int? = null,
	val iconUrl: String? = null,
	val title: String? = null
)


