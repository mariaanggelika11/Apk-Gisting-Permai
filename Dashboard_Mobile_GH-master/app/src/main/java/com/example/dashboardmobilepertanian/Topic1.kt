package com.example.dashboardmobilepertanian

import com.google.gson.annotations.SerializedName

data class Topic1(
    @SerializedName("timestamp") val timestamp: String,
    @SerializedName("ph") val ph: Double,
    @SerializedName("tds") val tds: Double,
    @SerializedName("suhu_air") val suhuAir: Double,
    @SerializedName("winddirection") val windDirection: Double,
    @SerializedName("kecepatan_angin") val kecepatanAngin: Double,
    @SerializedName("infrared1") val infrared1: Double,
    @SerializedName("infrared2") val infrared2: Double,
    @SerializedName("infrared3") val infrared3: Double,
    @SerializedName("berat1") val berat1: Double,
    @SerializedName("waterflow1") val waterflow1: Double,
    @SerializedName("waterflow2") val waterflow2: Double,
    @SerializedName("waterflow3") val waterflow3: Double,
    @SerializedName("waterflow4") val waterflow4: Double,
    @SerializedName("soilmoisture1") val soilmoisture1: Double,
    @SerializedName("soilmoisture2") val soilmoisture2: Double,
    @SerializedName("soilmoisture3") val soilmoisture3: Double,
    @SerializedName("soilmoisture4") val soilmoisture4: Double,
    @SerializedName("berat2") val berat2: Double,
    @SerializedName("berat3") val berat3: Double,
    @SerializedName("berat4") val berat4: Double,
    @SerializedName("suhu") val suhu: Double,
    @SerializedName("tekanan_udara") val tekananUdara: Double,
    @SerializedName("pompanutrisi") val pompaNutrisi: Int,
    @SerializedName("pompaair") val pompaAir: Int,
    @SerializedName("lampuuv") val lampuUv: Int,
    @SerializedName("pyrano") val pyrano: Double,
    @SerializedName("humidity") val humidity: Double,
    @SerializedName("svp") val svp: Double,
    @SerializedName("avp") val avp: Double,
    @SerializedName("vpd") val vpd: Double
)