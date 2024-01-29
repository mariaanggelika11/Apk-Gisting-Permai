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

class MainActivity6 : AppCompatActivity() {

    private lateinit var textViewTime6: TextView
    private lateinit var textViewDate6: TextView
    private lateinit var textViewsm1: TextView
    private lateinit var textViewsm2: TextView
    private lateinit var textViewsm3: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        textViewTime6 = findViewById(R.id.textViewTime6)
        textViewDate6 = findViewById(R.id.textViewDate6)
        textViewsm1 = findViewById(R.id.textViewsm1)
        textViewsm2 = findViewById(R.id.textViewsm2)
        textViewsm3 = findViewById(R.id.textViewsm3)

        fetchData()

        val imageView21: ImageView = findViewById(R.id.imageView21)
        imageView21.setOnClickListener {
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
                    if (it.result.isNotEmpty()) {
                        val topic1 = it.result[0]
                        val formattedDate =
                            SimpleDateFormat("dd-MM-yy HH:mm:ss").parse(topic1.datetime)

                        // Menambahkan pemeriksaan null dan memberikan nilai default jika diperlukan
                        textViewsm1.text = "${topic1.winddirect} %"
                        textViewsm2.text = "${topic1.anemo} %"
                        textViewsm3.text = "${topic1.dht} %"

                        // Update TextViewTime dan TextViewDate dengan waktu dari server (datetime dari getDataTopic1)
                        textViewTime6.text =
                            "Jam: " + formattedDate?.let { it1 ->
                                SimpleDateFormat("HH:mm:ss").format(
                                    it1
                                )
                            }
                        textViewDate6.text =
                            "Tanggal: " + formattedDate?.let { it1 ->
                                SimpleDateFormat("dd/MM/yyyy").format(
                                    it1
                                )
                            }

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
