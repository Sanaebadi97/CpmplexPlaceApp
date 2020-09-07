package info.sanaebadi.placeapp.mvvm.delegate.place

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.placeapp.databinding.PlaceItemBinding
import info.sanaebadi.placeapp.mvvm.base.ViewTypeDelegateAdapter
import info.sanaebadi.placeapp.util.loadCircleImage

class PlaceDelegateAdapter(
    private val listener: (PlaceItem) -> Unit,
) :
    ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        PlaceViewHolder(
            PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as PlaceViewHolder
        holder.bind(item as PlaceItem, listener)
    }

    class PlaceViewHolder(private val placeItemBinding: PlaceItemBinding) :
        RecyclerView.ViewHolder(placeItemBinding.root) {
        @SuppressLint("NewApi")
        fun bind(
            place: PlaceItem, listener: (PlaceItem) -> Unit,
        ) = with(itemView) {
            placeItemBinding.imagePlaceIcon.loadCircleImage(place.iconUrl!!)
            placeItemBinding.textPlaceTitle.text = place.title
            placeItemBinding.textPlaceShortAddress.text = place.shortAddress

            setOnClickListener { listener(place) }

        }
    }
}
