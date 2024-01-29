package com.example.dashboardmobilepertanian

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.dashboardmobilepertanian.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                loadData()
                Handler().postDelayed(this, 1000)
            }
        }, 1000)
        setupListener()
    }

    private fun setupListener() {
        with(bind){
            btnTable.setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://gh-fp.isi-net.org/dashboard.html#table-container")))
            }
            btnGraph.setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://gh-fp.isi-net.org/dashboard.html#judul_grafik")))
            }
        }
    }

    private fun loadData(){
        RetrofitClient.apiServiceInstance
            .getDataTopic1()
            .enqueue(object : Callback<DataTopic1Response> {
                override fun onResponse(
                    call: Call<DataTopic1Response>,
                    response: Response<DataTopic1Response>
                ) {
                    response.body()?.let {
                        val sensor = it.result[0]
                        val formattedDate = SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(
                            SimpleDateFormat("dd-MM-yy HH:mm:ss").parse(sensor.timestamp))
                        with(bind){
                            tvPh.text=sensor.ph.toString()
                            tvTimeStamp.text=formattedDate
                            tvTds.text="${sensor.tds} mg/L"
                            tvWaterTemperature.text="${sensor.suhuAir}° C"
                            tvWindDirection.text="${sensor.windDirection}°, ${getWindDirection(sensor.windDirection)}"
                            tvWindSpeed.text="${sensor.kecepatanAngin} m/s"
                            tvSoilMoisture1.text="${sensor.soilmoisture1} %"
                            tvSoilMoisture2.text="${sensor.soilmoisture2} %"
                            tvSoilMoisture3.text="${sensor.soilmoisture3} %"
                            tvSoilMoisture4.text="${sensor.soilmoisture4} %"
                            tvRoomTemperature.text="${sensor.suhu} ° C"
                            if(sensor.suhu<18||sensor.suhu>36){
                                cvRoomTemperature.setCardBackgroundColor(getColor(R.color.merah))
                            }else if(sensor.suhu in 25.0..32.0){
                                cvRoomTemperature.setCardBackgroundColor(getColor(R.color.ijomuda))
                            }else{
                                cvRoomTemperature.setCardBackgroundColor(getColor(R.color.kuning))
                            }
                            if(sensor.pompaNutrisi==0){
                                tvNutrientPump.text="Off"
                                cvNutrientPump.setCardBackgroundColor(getColor(R.color.white))
                            }else{
                                tvNutrientPump.text="On"
                                cvNutrientPump.setCardBackgroundColor(getColor(R.color.birumuda))
                            }
                            if(sensor.pompaAir==0){
                                tvCoolingSystem.text="Off"
                                cvCoolingSystem.setCardBackgroundColor(getColor(R.color.white))
                            }else{
                                tvCoolingSystem.text="On"
                                cvCoolingSystem.setCardBackgroundColor(getColor(R.color.birumuda))
                            }
                            tvHumidity.text = "${sensor.humidity}  %RH"
                        }
                    }
                }
                override fun onFailure(call: Call<DataTopic1Response>, t: Throwable) {
                    t.message?.let {
                        Toast.makeText(this@MainActivity,it, Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
    fun getWindDirection(windDirection: Double): String {
        return when (windDirection) {
            in 0.0..22.5 -> "N"
            in 22.5..45.0 -> "NNE"
            in 45.0..67.5 -> "NE"
            in 67.5..90.0 -> "ENE"
            in 90.0..112.5 -> "E"
            in 112.5..135.0 -> "ESE"
            in 135.0..157.5 -> "SE"
            in 157.5..180.0 -> "SSE"
            in 180.0..202.5 -> "S"
            in 202.5..225.0 -> "SSW"
            in 225.0..247.5 -> "SW"
            in 247.5..270.0 -> "WSW"
            in 270.0..292.5 -> "W"
            in 292.5..315.0 -> "WNW"
            in 315.0..337.5 -> "NW"
            in 337.5..360.0 -> "NNW"
            else -> "Invalid wind direction"
        }
    }
}