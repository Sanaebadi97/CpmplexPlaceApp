package info.sanaebadi.domain.interactor.place

import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import info.sanaebadi.domain.interactor.base.SingleUseCase
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.repository.place.favorite.FavoriteRepository
import io.reactivex.Single
import javax.inject.Inject

class FavoriteUseCase @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread,
    private val favoriteRepository: FavoriteRepository
) : SingleUseCase<FavoriteListItem, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: String): Single<FavoriteListItem> {
        return favoriteRepository.getFavorites()
    }

}