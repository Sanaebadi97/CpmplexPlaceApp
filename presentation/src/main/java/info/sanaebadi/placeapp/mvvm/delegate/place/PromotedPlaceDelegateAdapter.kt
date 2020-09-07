package info.sanaebadi.placeapp.mvvm.delegate.place

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.PromotedItemBinding
import info.sanaebadi.placeapp.mvvm.base.ViewType
import info.sanaebadi.placeapp.mvvm.base.ViewTypeDelegateAdapter
import info.sanaebadi.placeapp.util.isLollipopOrAbove
import info.sanaebadi.placeapp.util.loadCircleImage

class PromotedPlaceDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        PromotedPlaceViewHolder(
            PromotedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as PromotedPlaceViewHolder
        holder.bind(item as PromotedItem)
    }

    class PromotedPlaceViewHolder(private val promotedItemBinding: PromotedItemBinding) :
        RecyclerView.ViewHolder(promotedItemBinding.root) {
        @SuppressLint("NewApi")
        fun bind(promoted: PromotedItem) = with(itemView) {
            promotedItemBinding.imagePlaceIcon.loadCircleImage(promoted.iconUrl!!)
            promotedItemBinding.textPlaceTitle.text = promoted.title
            promotedItemBinding.textPlaceShortAddress.text = promoted.shortAddress

            isLollipopOrAbove {
                promotedItemBinding.imagePlaceIcon.transitionName = "transition${promoted.id}"
            }
        }
    }
}