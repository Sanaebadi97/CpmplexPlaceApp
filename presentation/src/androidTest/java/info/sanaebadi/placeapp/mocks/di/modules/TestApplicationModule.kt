package info.sanaebadi.placeapp.mocks.di.modules

import dagger.Module
import dagger.Provides
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import info.sanaebadi.placeapp.mocks.model.repositories.FakePlaceRepository
import info.sanaebadi.placeapp.util.AppSchedulerProvider
import info.sanaebadi.placeapp.util.SchedulerProvider
import javax.inject.Singleton

@Module
class TestApplicationModule(
    private val placeRepository: PlaceRepository = FakePlaceRepository(),
) {


    @Provides
    @Singleton
    fun providePlacesRepository(): PlaceRepository {
        return placeRepository
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}