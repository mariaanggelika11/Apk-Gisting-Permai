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

class MainActivity5 : AppCompatActivity() {

    private lateinit var textViewTime5: TextView
    private lateinit var textViewDate5: TextView
    private lateinit var textViewwd: TextView
    private lateinit var textViewws: TextView
    private lateinit var textViewrt: TextView
    private lateinit var textViewh: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        textViewTime5 = findViewById(R.id.textViewTime5)
        textViewDate5 = findViewById(R.id.textViewDate5)
        textViewwd = findViewById(R.id.textViewwd)
        textViewws = findViewById(R.id.textViewws)
        textViewrt = findViewById(R.id.textViewrt)
        textViewh = findViewById(R.id.textViewh)


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
                        textViewwd.text = "${topic1.winddirect} N"
                        textViewws.text = "${topic1.anemo} m/s"
                        textViewrt.text = "${topic1.dht} %RH"
                        textViewh.text = "${topic1.dht} %RH"

                        // Update TextViewTime dan TextViewDate dengan waktu dari server (datetime dari getDataTopic1)
                        textViewTime5.text =
                            "Jam: " + formattedDate?.let { it1 ->
                                SimpleDateFormat("HH:mm:ss").format(
                                    it1
                                )
                            }
                        textViewDate5.text =
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
