package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.User
import io.reactivex.Single

interface UserService {

    fun getUsers(): Single<List<User>>
}