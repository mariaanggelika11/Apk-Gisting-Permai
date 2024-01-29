package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL_VPS = "https://vps.isi-net.org:5001/"

    private val retrofitVPS = Retrofit.Builder()
        .baseUrl(BASE_URL_VPS)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiServiceInstance: ApiService = retrofitVPS.create(ApiService::class.java)
}
