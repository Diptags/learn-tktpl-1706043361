package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.repositories

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.api.ApiHelper
import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}