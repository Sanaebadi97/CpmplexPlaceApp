package info.sanaebadi.domain.model.place.favorite

import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.domain.model.base.ViewType

data class FavoriteListItem(
    val favoriteIds: List<Int>? = null
) : ViewType , BaseDomainModel {
    override fun getViewType(): Int {
        TODO("Not yet implemented")
    }
}



