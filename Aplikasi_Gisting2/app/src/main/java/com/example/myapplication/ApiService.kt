package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("GetDataGistingNew")
    fun getDataTopic1(): Call<DataTopic1Response>
}