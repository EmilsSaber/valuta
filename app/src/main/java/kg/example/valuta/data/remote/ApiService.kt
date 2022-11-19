package kg.example.valuta.data.remote

import kg.example.valuta.data.remote.model.Currencies
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("daily_json.js")
    fun getCurrency(
    ): Call<Currencies>
}