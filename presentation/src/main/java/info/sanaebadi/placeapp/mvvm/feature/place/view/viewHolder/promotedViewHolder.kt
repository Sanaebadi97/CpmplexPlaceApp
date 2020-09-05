package info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder

import android.view.View
import info.sanaebadi.domain.model.place.PlaceItem
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.base.BaseViewHolder

open class promotedViewHolder(itemView: View) : BaseViewHolder<PlaceItem>(itemView) {

    override fun bind(item: PlaceItem) {
        //Do your view assignment here from the data model
    }
}
