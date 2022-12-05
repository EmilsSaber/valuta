package kg.example.valuta.repository
import androidx.lifecycle.MutableLiveData
import kg.example.valuta.core.remote.RetrofitClient
import kg.example.valuta.data.remote.ApiService
import kg.example.valuta.data.remote.model.Currencies
import kg.example.valuta.result.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }
    fun getCurrency(): MutableLiveData<Resource<Currencies>> {
        return getCurrently()
    }

    private fun getCurrently(): MutableLiveData<Resource<Currencies>> {
        val data = MutableLiveData<Resource<Currencies>>()
        data.value = Resource.loading()
        apiService.getCurrency().enqueue(
            object : Callback<Currencies> {
                override fun onResponse(call: Call<Currencies>, response: Response<Currencies>) {
                    if (response.isSuccessful){
                        data.value = Resource.success(response.body())
                    }}
                override fun onFailure(call: Call<Currencies>, t: Throwable) {
                    data.value = Resource.error( null,t.message)
                }
            }
        )
        return data
    }
}