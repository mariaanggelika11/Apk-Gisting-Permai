package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity4 : AppCompatActivity() {

    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textViewTime: TextView
    private lateinit var textViewDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textViewTime = findViewById(R.id.textViewTime)
        textViewDate = findViewById(R.id.textViewDate)

        // Jalankan fungsi untuk memperbarui jam dan tanggal setiap detik
        updateDateTime()

        // Tambahkan listener klik untuk imageView28
        val imageView28: ImageView = findViewById(R.id.imageView28)
        imageView28.setOnClickListener {
            // Panggil metode untuk kembali ke MainActivity2
            navigateToMainActivity2()
        }

        // Panggil metode untuk memperbarui data dummy secara periodik
        updateDummyDataPeriodically()
    }

    private fun updateDummyDataPeriodically() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            @SuppressLint("SetTextI18n")
            override fun run() {
                // Generate data dummy
                val dummyData1 = generateDummyData("ph")
                val dummyData2 = generateDummyData("suhuair")
                val dummyData3 = generateDummyData("tdsmeter")

                // Tampilkan data dummy di TextView
                val phFormatted = String.format("%.1f", dummyData1.toDouble())
                val suhuAirFormatted = String.format("%.1f", dummyData2.toDouble())
                val tdsMeterFormatted = String.format("%.1f", dummyData3.toDouble())

                textView4.text = "$phFormatted ℃"
                textView5.text = "$suhuAirFormatted ℃"
                textView6.text = "$tdsMeterFormatted mg/L"

                // Atur pengulangan setiap detik
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun generateDummyData(dataType: String): String {
        // Implementasi logika penghasilan data dummy sesuai kebutuhan Anda
        // Di sini, saya menggunakan angka acak antara 0 dan 100
        val randomValue = (Math.random() * 100).toInt() / 10.0

        return when (dataType) {
            "ph" -> randomValue.toString()
            "suhuair" -> randomValue.toString()
            "tdsmeter" -> randomValue.toString()
            else -> "0.0" // Nilai default jika jenis data tidak dikenali
        }
    }

    private fun updateDateTime() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            @SuppressLint("SetTextI18n")
            override fun run() {
                // Format waktu dan tanggal
                val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

                // Dapatkan waktu dan tanggal saat ini
                val calendar = Calendar.getInstance()
                val time = timeFormat.format(calendar.time)
                val date = dateFormat.format(calendar.time)

                // Tampilkan waktu dan tanggal di TextView
                textViewTime.text = "Waktu      : $time"
                textViewDate.text = "Tanggal   : $date"

                // Atur pengulangan setiap detik
                handler.postDelayed(this, 1000)
            }
        })
    }

    // Metode untuk kembali ke MainActivity2
    private fun navigateToMainActivity2() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        finish()  // Optional, untuk menutup MainActivity4 setelah berpindah ke MainActivity2
    }
}
