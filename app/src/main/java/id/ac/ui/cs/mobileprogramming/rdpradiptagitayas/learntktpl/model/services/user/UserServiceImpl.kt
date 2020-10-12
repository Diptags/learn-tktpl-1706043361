package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.entities.User
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class UserServiceImpl : UserService {

    override fun getUsers(): Single<List<User>> {
        return Rx2AndroidNetworking.get("https://5e510330f2c0d300147c034c.mockapi.io/users")
            .build()
            .getObjectListSingle(User::class.java)
    }
}