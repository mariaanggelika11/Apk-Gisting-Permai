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

class MainActivity8 : AppCompatActivity() {

    private lateinit var textViewTime8: TextView
    private lateinit var textViewDate8: TextView
    private lateinit var textViewwf1: TextView
    private lateinit var textViewwf2: TextView
    private lateinit var textViewwf3: TextView
    private lateinit var textViewwf4: TextView
    private lateinit var textViewwf5: TextView
    private lateinit var textViewwf6: TextView
    private lateinit var textViewwf7: TextView
    private lateinit var textViewwf8: TextView
    private lateinit var textViewwf9: TextView
    private lateinit var textViewwf10: TextView
    private lateinit var textViewwf11: TextView
    private lateinit var textViewwf12: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        textViewTime8 = findViewById(R.id.textViewTime8)
        textViewDate8 = findViewById(R.id.textViewDate8)
        textViewwf1 = findViewById(R.id.textViewwf1)
        textViewwf2 = findViewById(R.id.textViewwf2)
        textViewwf3 = findViewById(R.id.textViewwf3)
        textViewwf4 = findViewById(R.id.textViewwf4)
        textViewwf5 = findViewById(R.id.textViewwf5)
        textViewwf6 = findViewById(R.id.textViewwf6)
        textViewwf7 = findViewById(R.id.textViewwf7)
        textViewwf8 = findViewById(R.id.textViewwf8)
        textViewwf9 = findViewById(R.id.textViewwf9)
        textViewwf10 = findViewById(R.id.textViewwf10)
        textViewwf11 = findViewById(R.id.textViewwf11)
        textViewwf12 = findViewById(R.id.textViewwf12)


        fetchData()

        val imageView112: ImageView = findViewById(R.id.imageView112)
        imageView112.setOnClickListener {
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
                        textViewwf1.text = "${topic1.waterflow1} L/H"
                        textViewwf2.text = "${topic1.waterflow2} L/H"
                        textViewwf3.text = "${topic1.waterflow3} L/H"
                        textViewwf4.text = "${topic1.waterflow4} L/H"
                        textViewwf5.text = "${topic1.waterflow5} L/H"
                        textViewwf6.text = "${topic1.waterflow6} L/H"
                        textViewwf7.text = "${topic1.waterflow7} L/H"
                        textViewwf8.text = "${topic1.waterflow8} L/H"
                        textViewwf9.text = "${topic1.waterflow9} L/H"
                        textViewwf10.text = "${topic1.waterflow10} L/H"
                        textViewwf11.text = "${topic1.waterflow11} L/H"
                        textViewwf12.text = "${topic1.waterflow12} L/H"

                        // Update TextViewTime dan TextViewDate dengan waktu dari server (datetime dari getDataTopic1)
                        textViewTime8.text =
                            "Jam: " + formattedDate?.let { it1 ->
                                SimpleDateFormat("HH:mm:ss").format(
                                    it1
                                )
                            }
                        textViewDate8.text =
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
