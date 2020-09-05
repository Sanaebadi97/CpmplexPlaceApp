package info.sanaebadi.placeapp.mvvm.feature.place.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.R
import info.sanaebadi.placeapp.databinding.PlaceItemBinding
import info.sanaebadi.placeapp.databinding.PromotedItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.PlaceViewHolder
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.PromotedViewHolder
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.base.BaseViewHolder

class DataAdapter(private var adapterDataList: List<Any> = emptyList()) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_PROMOTED = 0
        private const val TYPE_PLACES = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_PROMOTED -> {
                val promotedItemBinding =
                    PromotedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PromotedViewHolder(promotedItemBinding)
            }
            TYPE_PLACES -> {
                val placeItemBinding =
                    PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PlaceViewHolder(placeItemBinding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when (holder) {
            is PromotedViewHolder -> holder.bind(element as PromotedItem)
            is PlaceViewHolder -> holder.bind(element as PlaceItem)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (adapterDataList[position]) {
            is PromotedItem -> TYPE_PROMOTED
            is PlaceItem -> TYPE_PLACES
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }


    override fun getItemCount() = adapterDataList.size
}