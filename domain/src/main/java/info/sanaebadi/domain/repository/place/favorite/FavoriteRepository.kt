package info.sanaebadi.domain.repository.place.favorite

import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import io.reactivex.Single

interface FavoriteRepository {
    fun getFavorites(): Single<FavoriteListItem>
}