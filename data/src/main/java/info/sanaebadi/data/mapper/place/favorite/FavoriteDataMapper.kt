package info.sanaebadi.data.mapper.place.favorite

import info.sanaebadi.data.entity.place.favorite.FavoriteEntity
import info.sanaebadi.data.mapper.base.DataLayerMapper
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteDataMapper @Inject constructor() : DataLayerMapper<FavoriteEntity, FavoriteListItem> {

    override fun toDomain(e: FavoriteEntity?): FavoriteListItem {
        return FavoriteListItem(e?.favoriteIds)
    }

    override fun toEntity(d: FavoriteListItem?): FavoriteEntity? {
        return null
    }
}