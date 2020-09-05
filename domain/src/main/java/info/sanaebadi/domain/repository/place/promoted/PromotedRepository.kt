package info.sanaebadi.domain.repository.place.promoted

import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import io.reactivex.Single

interface PromotedRepository {
    fun getPromotedPlaces(): Single<PromotedListModel>
}