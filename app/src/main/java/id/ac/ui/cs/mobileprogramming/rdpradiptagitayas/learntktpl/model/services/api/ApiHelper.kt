package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.model.services.api

class ApiHelper(private val apiService: ApiService) {

    fun getUsers() = apiService.getUsers()

}