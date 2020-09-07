package info.sanaebadi.placeapp.mvvm.ui.`interface`

import android.view.View

open interface OnViewListener {
    fun setFavoriteItem(view: View, position: Int)
}