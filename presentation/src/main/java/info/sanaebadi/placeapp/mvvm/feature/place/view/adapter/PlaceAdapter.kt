package info.sanaebadi.placeapp.mvvm.feature.place.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.placeapp.databinding.PlaceItemBinding
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.PlaceViewHolder
import info.sanaebadi.placeapp.mvvm.ui.`interface`.OnItemClickListener
import info.sanaebadi.placeapp.mvvm.ui.`interface`.OnViewListener
import kotlinx.android.synthetic.main.place_item.view.*

class PlaceAdapter(
    private var placeList: List<PlaceItem?> = emptyList()
) :
    RecyclerView.Adapter<PlaceViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val placeItemBinding =
            PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(placeItemBinding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(placeList[position]!!)
        holder.itemView.setOnClickListener {
//            listener.onItemClick(position)
        }

//        onViewListener.setFavoriteItem(holder.itemView.image_favorite, position)

    }

    override fun getItemCount() = placeList.size


    fun updateList(list: List<PlaceItem?>) {
        placeList = list
        notifyDataSetChanged()
    }


}