package info.sanaebadi.domain.interactor.place

import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import info.sanaebadi.domain.interactor.base.SingleUseCase
import info.sanaebadi.domain.model.place.places.PlaceListModel
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import io.reactivex.Single
import javax.inject.Inject

class PlaceUseCase @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread,
    private val placeRepository: PlaceRepository,
) : SingleUseCase<PlaceListModel, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: String): Single<PlaceListModel> {
        return placeRepository.getPlaces()
    }
}