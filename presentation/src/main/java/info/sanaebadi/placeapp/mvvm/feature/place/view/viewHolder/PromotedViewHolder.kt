package info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.PromotedItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.base.BaseViewHolder

open class PromotedViewHolder(private val itemBinding: PromotedItemBinding) :
    BaseViewHolder<PromotedItem>(itemBinding.root) {

    override fun bind(item: PromotedItem) {
        itemBinding.textPlaceTitle.text = item.title
        itemBinding.textPlaceShortAddress.text = item.shortAddress

        Glide.with(itemView.context)
            .load(item.iconUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(itemBinding.imagePlaceIcon);
    }
}
