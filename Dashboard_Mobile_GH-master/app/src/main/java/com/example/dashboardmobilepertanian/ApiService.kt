package com.example.dashboardmobilepertanian

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("get100data")
    fun getDataTopic1(): Call<DataTopic1Response>
}