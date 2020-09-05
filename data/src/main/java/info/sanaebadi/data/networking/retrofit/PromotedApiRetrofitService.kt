package info.sanaebadi.data.networking.retrofit

import info.sanaebadi.data.entity.place.promoted.PromotedListEntity
import io.reactivex.Single
import retrofit2.http.GET

interface PromotedApiRetrofitService {
    @GET("promoted")
    fun getPromotedPlaces(): Single<PromotedListEntity>
}