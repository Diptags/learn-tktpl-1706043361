package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIService {
    @Headers("Content-Type: application/json")
    @POST("tktpl-1706043361")
    fun sendData(@Body params: ArrayList<HashMap<String, String>>): Call<ResponseBody>
}