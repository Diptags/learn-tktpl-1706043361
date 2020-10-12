package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl

import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.di.components.ApplicationComponent
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.di.components.DaggerApplicationComponent

// Berkas ini akan digunakan untuk keperluan Dependency Injection
class MainApplication : DaggerApplication() {

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