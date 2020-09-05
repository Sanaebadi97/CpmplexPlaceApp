package info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.placeapp.databinding.PlaceItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.base.BaseViewHolder

open class PlaceViewHolder(private val placeItemBinding: PlaceItemBinding) :
    BaseViewHolder<PlaceItem>(placeItemBinding.root) {

    override fun bind(item: PlaceItem) {
        placeItemBinding.textPlaceTitle.text = item.title
        placeItemBinding.textPlaceShortAddress.text = item.shortAddress

        Glide.with(itemView.context)
            .load(item.iconUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(placeItemBinding.imagePlaceIcon)
    }
}