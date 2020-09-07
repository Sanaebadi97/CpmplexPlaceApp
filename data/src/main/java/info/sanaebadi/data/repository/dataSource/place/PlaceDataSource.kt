package info.sanaebadi.data.repository.dataSource.place

import info.sanaebadi.data.entity.place.favorite.FavoriteEntity
import info.sanaebadi.data.entity.place.places.PlaceListEntity
import info.sanaebadi.data.entity.place.promoted.PromotedListEntity
import io.reactivex.Single

interface PlaceDataSource {
    fun getPlaces(): Single<PlaceListEntity>
    fun getPromoted(): Single<PromotedListEntity>
    fun getFavorites(): Single<FavoriteEntity>
}