package info.sanaebadi.placeapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import info.sanaebadi.placeapp.mvvm.feature.place.view.MainActivity
import info.sanaebadi.placeapp.mvvm.feature.place.view.fragment.DetailsFragment
import info.sanaebadi.placeapp.mvvm.feature.place.view.fragment.PlaceFragment
import info.sanaebadi.placeapp.mvvm.feature.place.view.fragment.PromotedFragment

@Module
abstract class BuildersModule {

    //TODO:DEFINE FRAGMENTS HERE

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun bindProductsPlaceFragment(): PlaceFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun bindProductsPromotedFragment(): PromotedFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun bindProductsDetailsFragment(): DetailsFragment


}