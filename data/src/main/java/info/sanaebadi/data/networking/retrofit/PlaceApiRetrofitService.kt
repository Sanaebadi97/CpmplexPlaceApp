package info.sanaebadi.data.networking.retrofit

import info.sanaebadi.data.entity.place.PlaceListEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface PlaceApiRetrofitService {
    @Headers("Content-Type: application/json")
    @GET("places")
    fun getPlaces(): Single<PlaceListEntity>
}