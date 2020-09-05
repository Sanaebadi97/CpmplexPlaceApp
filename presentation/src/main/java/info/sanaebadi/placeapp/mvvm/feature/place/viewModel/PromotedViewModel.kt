package info.sanaebadi.placeapp.mvvm.feature.place.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.sanaebadi.domain.interactor.base.BaseSingleObserver
import info.sanaebadi.domain.interactor.place.PromotedUseCase
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import info.sanaebadi.placeapp.mvvm.base.MutableViewModel
import javax.inject.Inject

class PromotedViewModel @Inject constructor(
    private val promotedUseCase: PromotedUseCase
) : ViewModel() {

    var promoted = MutableLiveData<MutableViewModel<PromotedListModel>>()

    fun getPromoted() {
        val value = MutableViewModel<PromotedListModel>()
        value.setLoading(true)
        promoted.postValue(value)

        promotedUseCase.execute(object : BaseSingleObserver<PromotedListModel>() {
            override fun onSuccess(t: PromotedListModel) {
                super.onSuccess(t)
                value.setLoading(false)
                value.setThrowable(null)
                value.setData(t)
                promoted.postValue(value)

            }

            override fun onError(e: Throwable) {
                super.onError(e)
                value.setLoading(false)
                value.setThrowable(e)
                promoted.postValue(value)
            }

        }, "")
    }
}