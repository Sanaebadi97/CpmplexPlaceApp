package info.sanaebadi.placeapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import info.sanaebadi.placeapp.mvvm.feature.place.view.MainActivity

@Module
abstract class BuildersModule {

    //TODO:DEFIND FRAGMENTS HERE

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

}