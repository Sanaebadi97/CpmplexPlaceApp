package info.sanaebadi.placeapp.mvvm.feature.place.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.placeapp.mvvm.base.AdapterConstants
import info.sanaebadi.placeapp.mvvm.base.ViewType
import info.sanaebadi.placeapp.mvvm.base.ViewTypeDelegateAdapter
import info.sanaebadi.placeapp.mvvm.delegate.place.PlaceDelegateAdapter
import info.sanaebadi.placeapp.mvvm.delegate.place.PromotedPlaceDelegateAdapter

class PlaceAdapter(listener: (Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<ViewType> = ArrayList()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        delegateAdapters.put(AdapterConstants.PLACE_PROMOTED, PromotedPlaceDelegateAdapter())
        delegateAdapters.put(AdapterConstants.PLACE_LIST, PlaceDelegateAdapter(listener))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        delegateAdapters[viewType]?.onCreateViewHolder(parent)!!


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int): Unit =
        delegateAdapters[getItemViewType(position)]?.onBindViewHolder(holder, items[position])!!

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].getViewType()
    }

    private fun addItems(newItems: List<ViewType>) {
        items.addAll(newItems)
    }


    fun updateList(list: MutableList<ViewType>) {
        items = list
        notifyDataSetChanged()
    }


     fun addItemToList(items: List<ViewType>) {
        if (items.isNotEmpty()) {
            addItems(items)
        }
    }

}