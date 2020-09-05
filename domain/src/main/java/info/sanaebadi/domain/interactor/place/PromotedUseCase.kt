package info.sanaebadi.domain.interactor.place

import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import info.sanaebadi.domain.interactor.base.SingleUseCase
import info.sanaebadi.domain.model.place.promoted.PromotedListModel
import info.sanaebadi.domain.repository.place.promoted.PromotedRepository
import io.reactivex.Single
import javax.inject.Inject

class PromotedUseCase @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread,
    private val promotedRepository: PromotedRepository
) : SingleUseCase<PromotedListModel, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: String): Single<PromotedListModel> {
        return promotedRepository.getPromotedPlaces()
    }

}