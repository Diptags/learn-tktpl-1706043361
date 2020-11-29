package id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.services

import id.ac.ui.cs.mobileprogramming.rdpradiptagitayas.learntktpl.utils.RetrofitBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIServiceImpl {
    fun sendData(params: ArrayList<HashMap<String, String>>, onResult: (ResponseBody?) -> Unit) {
        val retrofit = RetrofitBuilder.buildService(APIService::class.java)
        retrofit.sendData(params).enqueue(
            object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val responseData = response.body()
                    onResult(responseData)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    onResult(null)
                }
            }
        )
    }
}