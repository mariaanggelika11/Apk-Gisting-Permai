package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity3 : AppCompatActivity() {

    private lateinit var textViewTime: TextView
    private lateinit var textViewDate: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        textViewTime = findViewById(R.id.textViewTime3)
        textViewDate = findViewById(R.id.textViewDate3)
        textView2 = findViewById(R.id.textViewUV)
        textView3 = findViewById(R.id.textViewCS)

        fetchData()

        val imageView28: ImageView = findViewById(R.id.imageView28)
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
            @SuppressLint("SetTextI18n", "SimpleDateFormat")
            override fun onResponse(
                call: Call<DataTopic1Response>,
                response: Response<DataTopic1Response>
            ) {
                response.body()?.let {
                    val topic1 = it.result[0]
                    val formattedDate =
                        SimpleDateFormat("dd-MM-yy HH:mm:ss").parse(topic1.datetime)

                    // Set nilai UV Lampu berdasarkan jam
                    val uvLampuStatus = when {
                        Calendar.getInstance().get(Calendar.HOUR_OF_DAY) in 18..23 -> "On"
                        Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == 0 ||
                                Calendar.getInstance().get(Calendar.HOUR_OF_DAY) in 1..6 -> "On"
                        else -> "Off"
                    }

                    // Set nilai Cooling System berdasarkan jam
                    val coolingSystemStatus = when {
                        (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == 11 &&
                                Calendar.getInstance().get(Calendar.MINUTE) in 0..14) ||
                                (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == 14 &&
                                        Calendar.getInstance().get(Calendar.MINUTE) in 0..14) -> "On"
                        else -> "Off"
                    }

                    // Update TextView
                    textView2.text = uvLampuStatus
                    textView3.text = coolingSystemStatus

                    // Update TextViewTime dan TextViewDate dengan waktu dari server (datetime dari getDataTopic1)
                    textViewTime.text =
                        "Jam: " + formattedDate?.let { it1 ->
                            SimpleDateFormat("HH:mm:ss").format(
                                it1
                            )
                        }
                    textViewDate.text =
                        "Tanggal: " + formattedDate?.let { it1 ->
                            SimpleDateFormat("dd/MM/yyyy").format(
                                it1
                            )
                        }
                }
            }

            override fun onFailure(call: Call<DataTopic1Response>, t: Throwable) {
                // Handle kegagalan panggilan API jika diperlukan
                Log.d("TAG", t.message.toString())
            }
        })
    }
}
