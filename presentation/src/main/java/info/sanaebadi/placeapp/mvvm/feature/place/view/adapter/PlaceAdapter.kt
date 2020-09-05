package info.sanaebadi.placeapp.mvvm.feature.place.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.placeapp.databinding.PlaceItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.PlaceViewHolder
import kotlinx.android.synthetic.main.place_item.view.*

class PlaceAdapter(
    private var onItemView: OnItemView,
    private var listener: ItemClickListener,
    private var placeList: List<PlaceItem?> = emptyList()
) :
    RecyclerView.Adapter<PlaceViewHolder>() {

    companion object {
        var listener: ItemClickListener? = null
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val placeItemBinding =
            PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(placeItemBinding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(placeList[position]!!)
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }

        onItemView.onFavoriteItem(holder.itemView.image_favorite , position)

    }

    override fun getItemCount() = placeList.size

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnItemView {
        fun onFavoriteItem(view: View , position: Int)
    }

    fun updateList(list: List<PlaceItem?>) {
        placeList = list
        notifyDataSetChanged()
    }
}