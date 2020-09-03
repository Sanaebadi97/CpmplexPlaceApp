package info.sanaebadi.data.networking.retrofit

import info.sanaebadi.data.entity.place.PlaceEntity
import io.reactivex.Single
import retrofit2.http.GET

interface PlaceApiRetrofitService {
    @GET("places")
    fun getPlaces(): Single<List<PlaceEntity>>
}