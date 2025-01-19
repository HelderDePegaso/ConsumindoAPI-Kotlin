package com.tarefa.com.servicos

import com.tarefa.com.model.CaesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CaesApiService {
    @GET("breeds/image/random")
    suspend fun obterAutomaticamenteImagensDeCaes(): CaesResponse
}

object RetrofitInstance {
    private const val BASE_URL = "https://dog.ceo/api/"

    val api: CaesApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CaesApiService::class.java)
    }


}
