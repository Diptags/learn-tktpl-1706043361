package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.base.BaseApplication
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.modules.ActivityBindingModule
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.modules.ApplicationModule
import javax.inject.Singleton

// Injector untuk ViewModel
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): ApplicationComponent
    }
}