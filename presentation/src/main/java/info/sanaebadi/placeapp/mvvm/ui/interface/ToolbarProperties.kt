package info.sanaebadi.placeapp.mvvm.ui.`interface`

import android.graphics.drawable.Drawable

interface ToolbarProperties {

    val toolbarTitle: String
    val toolbarBackground: Drawable
    val toolbarActionIcon: Drawable
    val toolbarSettigIcon: Drawable
    val outBoxSettingIcon: Drawable
    val toolbarSettingEnabled: Boolean
    val isToolbarVisible: Boolean
    val toolbarActionEnabled: Boolean
    val outBoxActionEnabled: Boolean
    val connectionDetectorEnabled: Boolean
    val searchToolbarEnabled : Boolean
    val searchViewQueryHint : String
    val searchViewInputType : Int
    var  searchViewIsCleared : Boolean

    fun onToolbarActionIconClick()
    fun onToolbarSettingIconClick()
}