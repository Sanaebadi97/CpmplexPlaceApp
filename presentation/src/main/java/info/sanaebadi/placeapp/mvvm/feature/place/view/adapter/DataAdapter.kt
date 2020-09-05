package info.sanaebadi.placeapp.mvvm.feature.place.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.placeapp.mvvm.feature.place.view.viewHolder.base.BaseViewHolder

class DataAdapter(private var adapterDataList: List<Any> = emptyList()) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {


    companion object {
        private const val TYPE_FAMILY = 0
        private const val TYPE_FRIEND = 1
        private const val TYPE_COLLEAGUE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}