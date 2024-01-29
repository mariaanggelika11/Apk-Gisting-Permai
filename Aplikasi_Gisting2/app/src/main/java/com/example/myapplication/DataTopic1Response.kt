package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class DataTopic1Response(
    @SerializedName("count") val count: Int,
    @SerializedName("result") val result: List<Topic1>
)