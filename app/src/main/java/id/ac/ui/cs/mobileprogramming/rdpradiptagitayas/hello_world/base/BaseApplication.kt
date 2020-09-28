package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.base

import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.components.ApplicationComponent
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.components.DaggerApplicationComponent

// Berkas ini akan digunakan untuk keperluan Dependency Injection
class BaseApplication : DaggerApplication() {

    // Override untuk persiapan dependency injection
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: ApplicationComponent =
            DaggerApplicationComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

    // Override menggunakan Stetho untuk keperluan debugging
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}