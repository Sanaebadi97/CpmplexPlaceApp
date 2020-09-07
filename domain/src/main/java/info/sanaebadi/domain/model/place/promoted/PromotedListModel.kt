package info.sanaebadi.domain.model.place.promoted

import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.domain.model.base.ViewType

data class PromotedListModel(
	val promotedList: List<PromotedItem>? = null
) : BaseDomainModel

data class PromotedItem(
	val score: Double? = null,
	val shortAddress: String? = null,
	val bannerUrl: String? = null,
	val description: String? = null,
	val id: Int? = null,
	val iconUrl: String? = null,
	val title: String? = null
) : BaseDomainModel, ViewType {
    override fun getViewType(): Int = 1
}



