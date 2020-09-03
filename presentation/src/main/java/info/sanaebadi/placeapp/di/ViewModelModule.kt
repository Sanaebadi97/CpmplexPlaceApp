package info.sanaebadi.placeapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import info.sanaebadi.placeapp.mvvm.feature.place.viewModel.PlaceViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PlaceViewModel::class)
    internal abstract fun providesPlaceViewModel(viewModel: PlaceViewModel): ViewModel
}