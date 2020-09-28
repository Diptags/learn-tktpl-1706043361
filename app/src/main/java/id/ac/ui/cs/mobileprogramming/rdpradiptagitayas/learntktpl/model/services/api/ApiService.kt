package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.api

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}