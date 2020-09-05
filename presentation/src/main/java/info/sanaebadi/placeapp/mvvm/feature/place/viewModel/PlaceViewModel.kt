package info.sanaebadi.placeapp.mvvm.feature.place.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.sanaebadi.domain.interactor.base.BaseSingleObserver
import info.sanaebadi.domain.interactor.place.PlaceUseCase
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.placeapp.mvvm.base.MutableViewModel
import javax.inject.Inject

class PlaceViewModel @Inject constructor(
    private val placeUseCase: PlaceUseCase,
) : ViewModel() {

    var place = MutableLiveData<MutableViewModel<PlaceListModel>>()


    fun getPlaces() {
        val value = MutableViewModel<PlaceListModel>()
        value.setLoading(true)
        place.postValue(value)

        placeUseCase.execute(object : BaseSingleObserver<PlaceListModel>() {
            override fun onSuccess(t: PlaceListModel) {
                super.onSuccess(t)
                value.setLoading(false)
                value.setThrowable(null)
                value.setData(t)
                place.postValue(value)

            }

            override fun onError(e: Throwable) {
                super.onError(e)
                value.setLoading(false)
                value.setThrowable(e)
                place.postValue(value)
            }

        }, "")
    }
}