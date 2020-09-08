package info.sanaebadi.placeapp.mvvm.feature.place.view.viewModel

import android.annotation.SuppressLint
import info.sanaebadi.domain.interactor.place.PlaceUseCase
import info.sanaebadi.placeapp.mvvm.base.BasePresenter
import info.sanaebadi.placeapp.mvvm.base.PlacesView
import info.sanaebadi.placeapp.util.SchedulerProvider
import javax.inject.Inject

class PlaceViewModel @Inject constructor(
    private val placeUseCase: PlaceUseCase,
    private val schedulerProvider: SchedulerProvider
) : BasePresenter<PlacesView>() {

    @SuppressLint("CheckResult")
    fun getPlaces() {
        view?.showLoading()
        placeUseCase.execute()
            .subscribeOn(schedulerProvider.ioScheduler())
            .observeOn(schedulerProvider.uiScheduler())
            .subscribe({ placeData ->
                view?.hideLoading()
                view?.showDetails(placeData)
            },
                { error ->
                    view?.hideLoading()
                    view?.showError(error.localizedMessage!!)
                })
    }

}