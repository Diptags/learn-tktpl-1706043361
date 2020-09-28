package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.repositories.MainRepository
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.api.ApiHelper
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.main.MainViewModel

class ViewModelFactoryModule(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}