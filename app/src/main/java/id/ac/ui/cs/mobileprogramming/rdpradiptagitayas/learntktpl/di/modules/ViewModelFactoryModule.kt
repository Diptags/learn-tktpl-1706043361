package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.repositories.UserRepository
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user.UserHelper
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.temp.TempViewModel

@Module
class ViewModelFactoryModule(private val userHelper: UserHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TempViewModel::class.java)) {
            return TempViewModel(UserRepository(userHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}