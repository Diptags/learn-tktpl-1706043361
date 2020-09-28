package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun provideListFragment(): ListFragment

    @ContributesAndroidInjector
    abstract fun provideDetailsFragment(): DetailsFragment
}