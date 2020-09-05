package info.sanaebadi.placeapp.mvvm.feature.place.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.placeapp.databinding.PromotedItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.PromotedViewHolder

class PromotedAdapter(private var promotedList: List<PromotedItem?> = emptyList()) :
    RecyclerView.Adapter<PromotedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotedViewHolder {
        val promotedItemBinding =
            PromotedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotedViewHolder(promotedItemBinding)
    }

    override fun onBindViewHolder(holder: PromotedViewHolder, position: Int) {
        holder.bind(promotedList[position]!!)
    }

    override fun getItemCount() = promotedList.size

}