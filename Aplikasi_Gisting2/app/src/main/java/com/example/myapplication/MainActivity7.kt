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

class MainActivity7 : AppCompatActivity() {

    private lateinit var textViewTime7: TextView
    private lateinit var textViewDate7: TextView
    private lateinit var textVieww1: TextView
    private lateinit var textVieww2: TextView
    private lateinit var textVieww3: TextView
    private lateinit var textVieww4: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        textViewTime7 = findViewById(R.id.textViewTime7)
        textViewDate7 = findViewById(R.id.textViewDate7)
        textVieww1 = findViewById(R.id.textVieww1)
        textVieww2 = findViewById(R.id.textVieww2)
        textVieww3 = findViewById(R.id.textVieww3)
        textVieww4 = findViewById(R.id.textVieww4)

        fetchData()

        val imageView28: ImageView = findViewById(R.id.imageView28)
        imageView28.setOnClickListener {
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
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.result.isNotEmpty()) {
                            val topic1 = it.result[0]
                            val formattedDate =
                                SimpleDateFormat("dd-MM-yy HH:mm:ss").parse(topic1.datetime)

                            // Menambahkan pemeriksaan null dan memberikan nilai default jika diperlukan
                            textVieww1.text = "${topic1.weight1} gr"
                            textVieww2.text = "${topic1.weight2} gr"
                            textVieww3.text = "${topic1.weight3} gr"
                            textVieww4.text = "${topic1.weight4} gr"

                            // Update TextViewTime dan TextViewDate dengan waktu dari server (datetime dari getDataTopic1)
                            textViewTime7.text =
                                "Jam: " + formattedDate?.let { it1 ->
                                    SimpleDateFormat("HH:mm:ss").format(
                                        it1
                                    )
                                }
                            textViewDate7.text =
                                "Tanggal: " + formattedDate?.let { it1 ->
                                    SimpleDateFormat("dd/MM/yyyy").format(
                                        it1
                                    )
                                }
                        } else {
                            Log.d("TAG", "Result list is empty.")
                        }
                    } ?: run {
                        Log.d("TAG", "Response body is null.")
                    }
                } else {
                    Log.d("TAG", "Response unsuccessful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<DataTopic1Response>, t: Throwable) {
                // Handle kegagalan panggilan API jika diperlukan
                Log.d("TAG", "API call failed: ${t.message}")
            }
        })
    }
}
