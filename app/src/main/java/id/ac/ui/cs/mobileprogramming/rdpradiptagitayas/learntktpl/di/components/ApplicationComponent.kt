package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.MainApplication
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.di.modules.ApplicationModule
import javax.inject.Singleton

// Injector untuk ViewModel
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MainApplication): Builder
        fun build(): ApplicationComponent
    }
}