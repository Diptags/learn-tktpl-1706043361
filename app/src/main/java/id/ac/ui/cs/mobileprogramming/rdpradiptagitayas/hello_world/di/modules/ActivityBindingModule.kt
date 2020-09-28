package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.ui.main.MainActivity
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.ui.main.MainFragmentBindingModule

// Module yang di bind ke setiap activity yang membutuhkan dependency injection
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}