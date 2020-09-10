package info.sanaebadi.domain.interactor.place

import info.sanaebadi.domain.model.place.PlaceData
import info.sanaebadi.domain.model.place.favorite.FavoriteListItem
import info.sanaebadi.domain.model.place.places.PlaceItem
import info.sanaebadi.domain.model.place.promoted.PromotedItem
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import io.reactivex.Single
import io.reactivex.SingleEmitter
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class PlaceUseCaseTest {

    @Mock
    lateinit var mockPlaceRepository: PlaceRepository

    lateinit var getPlacesUseCase: PlaceUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getPlacesUseCase = PlaceUseCase(mockPlaceRepository)
    }

    @Test
    fun testExecute_placeListModelWithOneItem_emitListWithOneViewModel() {
        // Given
        val mockSingle = Single.create { e: SingleEmitter<PlaceData>? ->
            e?.onSuccess(
                PlaceData(
                    List<PromotedItem>(1), List<PlaceItem>(3), FavoriteListItem()
                )
            ))
        }

    }

    @After
    fun tearDown() {
    }

    @Test
    fun execute() {
    }
}