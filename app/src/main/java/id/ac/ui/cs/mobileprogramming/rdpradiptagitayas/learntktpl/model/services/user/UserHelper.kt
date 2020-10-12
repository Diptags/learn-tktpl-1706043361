package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.user

class UserHelper(private val userService: UserService) {

    fun getUsers() = userService.getUsers()
}