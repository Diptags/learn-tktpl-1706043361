package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.repositories.UserRepository
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user.UserHelper
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.ui.temp.TempViewModel

// Fungsi ini dirancang untuk override ViewModel milik Android
@Suppress("UNCHECKED_CAST")
class ApplicationViewModelFactory(private val userHelper: UserHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TempViewModel::class.java)) {
            return TempViewModel(UserRepository(userHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}