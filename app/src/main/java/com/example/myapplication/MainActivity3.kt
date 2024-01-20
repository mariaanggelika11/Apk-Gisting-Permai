package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {

    private lateinit var textViewTime: TextView
    private lateinit var textViewDate: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var imageView28: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewTime = findViewById(R.id.textViewTime)
        textViewDate = findViewById(R.id.textViewDate)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        imageView28 = findViewById(R.id.imageView28)

        fetchData()

        imageView28.setOnClickListener {
            // Handle klik pada imageView28 untuk kembali ke MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun fetchData() {
        val apiService = RetrofitClient.apiServiceInstance

        // Panggil metode getDataTopic1 untuk mendapatkan data Topic1
        apiService.getDataTopic1().enqueue(object : Callback<DataTopic1Response> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<DataTopic1Response>,
                response: Response<DataTopic1Response>
            ) {
                if (response.isSuccessful) {
                    // Update TextView2 dan TextView3 dengan data dari server
                    val topic1 = response.body()?.result?.get(0)
                    textView2.text = "UV Lampu: ${topic1?.uvlampu}"
                    textView3.text = "Cooling System: ${topic1?.coolingsystem}"

                    // Update TextViewTime dan TextViewDate dengan waktu dari server (datetime dari getDataTopic1)
                    textViewTime.text = "Waktu: ${topic1?.datetime}"
                    textViewDate.text = "Tanggal: ${topic1?.datetime}"

                    // Handle kondisi UV Lampu dan Cooling System
                    if (topic1?.uvlampu == 0.0 && topic1.coolingsystem == 0.0) {
                        // Kondisi "off"
                        textView2.text = "UV Lampu: Off"
                        textView3.text = "Cooling System: Off"
                    } else {
                        // Kondisi "on"
                        textView2.text = "UV Lampu: On"
                        textView3.text = "Cooling System: On"
                    }
                }
            }

            override fun onFailure(call: Call<DataTopic1Response>, t: Throwable) {
                // Handle kegagalan panggilan API jika diperlukan
            }
        })
    }
}
