package info.sanaebadi.placeapp.mvvm.base

import info.sanaebadi.domain.model.place.PlaceData

interface PlacesView {
    fun showDetails(places: PlaceData)
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
    fun showEmpty()
    fun hideError()
    fun hideEmpty()
}