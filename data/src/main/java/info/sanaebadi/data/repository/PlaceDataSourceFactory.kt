package info.sanaebadi.data.repository

import info.sanaebadi.data.networking.retrofit.PlaceApiRetrofitService
import io.reactivex.disposables.CompositeDisposable

class PlaceDataSourceFactory(
    private val apiRetrofitService: PlaceApiRetrofitService,
    private val compositeDisposable: CompositeDisposable
):DataS