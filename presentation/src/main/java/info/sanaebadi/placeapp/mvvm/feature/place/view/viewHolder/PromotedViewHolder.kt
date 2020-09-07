package info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.PromotedItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.base.BaseViewHolder

open class PromotedViewHolder(private val promotedItemBinding: PromotedItemBinding) :
    BaseViewHolder<PromotedItem>(promotedItemBinding.root) {

    override fun bind(item: PromotedItem) {
        promotedItemBinding.textPlaceTitle.text = item.title
        promotedItemBinding.textPlaceShortAddress.text = item.shortAddress

        Glide.with(itemView.context)
            .load(item.iconUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(promotedItemBinding.imagePlaceIcon)
    }
}