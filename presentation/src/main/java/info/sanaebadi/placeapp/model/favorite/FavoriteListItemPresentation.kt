package info.sanaebadi.placeapp.model.favorite

import info.sanaebadi.placeapp.mvvm.base.ViewType

data class FavoriteListItemPresentation(
	val favoriteIds: List<Int>? = null
) : ViewType{
	override fun getViewType(): Int {
		TODO("Not yet implemented")
	}

}



