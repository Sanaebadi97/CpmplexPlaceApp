package info.sanaebadi.placeapp.mvvm.delegate.place

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.placeapp.R
import info.sanaebadi.domain.model.base.ViewType

import info.sanaebadi.placeapp.mvvm.base.ViewTypeDelegateAdapter
import info.sanaebadi.placeapp.util.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) =
            LoadingViewHolder(parent.inflate(R.layout.list_item_loading))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}