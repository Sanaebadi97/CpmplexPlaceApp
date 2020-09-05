package info.sanaebadi.data.networking.retrofit

import info.sanaebadi.data.entity.place.favorite.FavoriteEntity
import io.reactivex.Single
import retrofit2.http.GET

interface FavoriteApiRetrofitService {
    @GET("favorites")
    fun getFavorites(): Single<FavoriteEntity>
}