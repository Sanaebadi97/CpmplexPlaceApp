package info.sanaebadi.data.repository.dataSource.place.favorite

import info.sanaebadi.data.mapper.place.favorite.FavoriteDataMapper
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.repository.CacheStrategy
import info.sanaebadi.domain.repository.place.favorite.FavoriteRepository
import io.reactivex.Single
import javax.inject.Inject

class FavoriteDataRepository @Inject constructor(
    private val favoriteDataSourceFactory: FavoriteDataSourceFactory,
    private val favoriteDataMapper: FavoriteDataMapper
) : FavoriteRepository {
    override fun getFavorites(): Single<FavoriteListItem> {
        return favoriteDataSourceFactory.create(CacheStrategy.ONLINE_FIRST).getFavorites()
            .map { data -> favoriteDataMapper.toDomain(data) }
    }

}