package kg.example.valuta.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.example.valuta.core.remote.RetrofitClient
import kg.example.valuta.data.remote.ApiService
import kg.example.valuta.data.remote.model.CurrensyModel
import kg.example.valuta.result.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getCurrensys(): MutableLiveData<Resource<CurrensyModel>> {
        return getCurrensy()
    }

    private fun getCurrensy(): MutableLiveData<Resource<CurrensyModel>> {
        val data = MutableLiveData<Resource<CurrensyModel>>()
//        data.value = Resource.loading()
        apiService.getCurrency().enqueue(
            object : Callback<CurrensyModel> {
                override fun onResponse(call: Call<CurrensyModel>, response: Response<CurrensyModel>) {
                    if (response.isSuccessful){
//                        data.value = Resource.success(response.body())
                        Log.e("ololo", "onResponse:" + response.body() )
                    }}
                override fun onFailure(call: Call<CurrensyModel>, t: Throwable) {
                    Log.d("ololo", "onSuccess: else")
//                    data.value = Resource.error( null,t.message)
                }
            }
        )
        return data
    }

}