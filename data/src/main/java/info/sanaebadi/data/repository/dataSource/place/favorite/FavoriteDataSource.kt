package info.sanaebadi.data.repository.dataSource.place.favorite

import info.sanaebadi.data.entity.place.favorite.FavoriteEntity
import io.reactivex.Single

interface FavoriteDataSource {
    fun getFavorites(): Single<FavoriteEntity>
}