package info.sanaebadi.placeapp.mvvm.feature.place.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.PromotedItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.PromotedViewHolder
import info.sanaebadi.placeapp.mvvm.ui.`interface`.OnItemClickListener
import info.sanaebadi.placeapp.mvvm.ui.`interface`.OnViewListener
import kotlinx.android.synthetic.main.place_item.view.*

class PromotedAdapter(
    private var promotedList: List<PromotedItem?> = emptyList()
) :
    RecyclerView.Adapter<PromotedViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotedViewHolder {
        val promItemBinding =
            PromotedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotedViewHolder(promItemBinding)
    }

    override fun onBindViewHolder(holder: PromotedViewHolder, position: Int) {
        holder.bind(promotedList[position]!!)
        holder.itemView.setOnClickListener {
//            listener.onItemClick(position)
        }

//        onViewListener.setFavoriteItem(holder.itemView.image_favorite, position)
    }

    override fun getItemCount() = promotedList.size


    fun updateList(list: List<PromotedItem?>) {
        promotedList = list
        notifyDataSetChanged()
    }


}