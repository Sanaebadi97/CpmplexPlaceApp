package info.sanaebadi.data.networking.retrofit

import info.sanaebadi.data.entity.place.places.PlaceListEntity
import io.reactivex.Single
import retrofit2.http.GET

interface PlaceApiRetrofitService {
    @GET("places")
    fun getPlaces(): Single<PlaceListEntity>
}