package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.di.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.MainApplication
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.persistence.ApplicationDatabase
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.API_URL
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.ConnectionHelper
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Module konfigurasi utama untuk dependecy injection
@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideAppContext(application: MainApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .baseUrl(API_URL)
        .build()

    @Provides
    @Singleton
    fun provideStudentDao(applicationDatabase: ApplicationDatabase) =
        applicationDatabase.studentDao()

    @Provides
    @Singleton
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @Singleton
    fun provideConnectionHelper(context: Context) = ConnectionHelper(context)
}