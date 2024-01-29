package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Topic1 (
    @SerializedName("datetime") val datetime: String,
    @SerializedName("soilmoisture_1") val soilmoisture1: Double,
    @SerializedName("soilmoisture_2") val soilmoisture2: Double,
    @SerializedName("soilmoisture_3") val soilmoisture3: Double,
    @SerializedName("waterflow_1") val waterflow1: Double,
    @SerializedName("waterflow_2") val waterflow2: Double,
    @SerializedName("waterflow_3") val waterflow3: Double,
    @SerializedName("waterflow_4") val waterflow4: Double,
    @SerializedName("waterflow_5") val waterflow5: Double,
    @SerializedName("waterflow_6") val waterflow6: Double,
    @SerializedName("waterflow_7") val waterflow7: Double,
    @SerializedName("waterflow_8") val waterflow8: Double,
    @SerializedName("waterflow_9") val waterflow9: Double,
    @SerializedName("waterflow_10") val waterflow10: Double,
    @SerializedName("waterflow_11") val waterflow11: Double,
    @SerializedName("waterflow_12") val waterflow12: Double,
    @SerializedName("weight_1") val weight1: Double,
    @SerializedName("weight_2") val weight2: Double,
    @SerializedName("weight_3") val weight3: Double?,
    @SerializedName("weight_4") val weight4: Double?,
    @SerializedName("infrared_1") val infrared1: Double,
    @SerializedName("infrared_2") val infrared2: Double,
    @SerializedName("winddirect") val winddirect: Double,
    @SerializedName("dht") val dht: Double,
    @SerializedName("ph") val ph: Double,
    @SerializedName("coolingsystem") val coolingsystem: Double,
    @SerializedName("uvlampu") val uvlampu: Int,
    @SerializedName("anemo") val anemo: Double,
    @SerializedName("suhuair") val suhuair: Double?,
    @SerializedName("tdsmeter") val tdsmeter: Double?,
    @SerializedName("raingauge") val raingauge: Double?
)