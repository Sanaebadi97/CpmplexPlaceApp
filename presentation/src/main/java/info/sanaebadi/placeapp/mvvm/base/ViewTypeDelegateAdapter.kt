package info.sanaebadi.placeapp.mvvm.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.domain.model.base.ViewType

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}