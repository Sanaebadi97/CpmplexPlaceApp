package info.sanaebadi.placeapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import info.sanaebadi.placeapp.mvvm.base.ViewModelFactory
import info.sanaebadi.placeapp.mvvm.feature.place.viewModel.places.PlaceViewModel
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?

    @Binds
    @IntoMap
    @ViewModelKey(PlaceViewModel::class)
    internal abstract fun providesPlaceViewModel(viewModel: PlaceViewModel): ViewModel
}