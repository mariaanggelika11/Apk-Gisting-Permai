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

class MainActivity4 : AppCompatActivity() {

    private lateinit var textViewTime4: TextView
    private lateinit var textViewDate4: TextView
    private lateinit var textViewtds: TextView
    private lateinit var textViewwt: TextView
    private lateinit var textViewph: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        textViewTime4 = findViewById(R.id.textViewTime4)
        textViewDate4 = findViewById(R.id.textViewDate4)
        textViewtds = findViewById(R.id.textViewtds)
        textViewwt = findViewById(R.id.textViewwt)
        textViewph = findViewById(R.id.textViewph)


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
                    if (it.result.isNotEmpty()) {
                        val topic1 = it.result[0]
                        val formattedDate =
                            SimpleDateFormat("dd-MM-yy HH:mm:ss").parse(topic1.datetime)
                        textViewtds.text = "${topic1.tdsmeter} mg/L"
                        textViewwt.text = "${topic1.suhuair} ℃"
                        textViewph.text = "${topic1.ph} ℃"

                        // Update TextViewTime dan TextViewDate dengan waktu dari server (datetime dari getDataTopic1)
                        textViewTime4.text =
                            "Jam: " + formattedDate?.let { it1 ->
                                SimpleDateFormat("HH:mm:ss").format(
                                    it1
                                )
                            }
                        textViewDate4.text =
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
            }

            override fun onFailure(call: Call<DataTopic1Response>, t: Throwable) {
                // Handle kegagalan panggilan API jika diperlukan
                Log.d("TAG", t.message.toString())
            }
        })
    }
}

