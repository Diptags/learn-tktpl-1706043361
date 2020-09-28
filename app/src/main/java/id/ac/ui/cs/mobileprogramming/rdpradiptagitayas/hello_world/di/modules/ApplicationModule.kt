package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.di.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.base.BaseApplication
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.data.services.RepoService
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.utils.API_URL
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.hello_world.utils.ConnectionHelper
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Module konfigurasi utama untuk dependecy injection
@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideAppContext(application: BaseApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .baseUrl(API_URL)
        .build()

    @Provides
    @Singleton
    fun provideRepoService(retrofit: Retrofit): RepoService {
        return retrofit.create(RepoService::class.java)
    }

    @Provides
    @Singleton
    fun provideConnectionHelper(context: Context) = ConnectionHelper(context)
}