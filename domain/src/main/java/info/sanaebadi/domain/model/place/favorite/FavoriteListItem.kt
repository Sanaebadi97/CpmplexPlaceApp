package info.sanaebadi.domain.model.place.favorite

import info.sanaebadi.domain.interactor.base.ViewType
import info.sanaebadi.domain.model.base.BaseDomainModel

data class FavoriteListItem(
	val favoriteIds: List<Int>? = null
):BaseDomainModel , ViewType {
	override fun getViewType(): Int {
		TODO("Not yet implemented")
	}
}


