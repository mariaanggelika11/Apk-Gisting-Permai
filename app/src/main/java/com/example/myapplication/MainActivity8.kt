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
import kotlin.random.Random

class MainActivity8 : AppCompatActivity() {

    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var textView8: TextView
    private lateinit var textView9: TextView
    private lateinit var textView10: TextView
    private lateinit var textView11: TextView
    private lateinit var textView12: TextView
    private lateinit var textViewTime: TextView
    private lateinit var textViewDate: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        // Inisialisasi TextView
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)
        textView8 = findViewById(R.id.textView8)
        textView9 = findViewById(R.id.textView9)
        textView10 = findViewById(R.id.textView10)
        textView11 = findViewById(R.id.textView11)
        textView12 = findViewById(R.id.textView12)
        textViewTime = findViewById(R.id.textViewTime)
        textViewDate = findViewById(R.id.textViewDate)

        // Jalankan fungsi untuk memperbarui jam dan tanggal setiap detik
        updateDateTime()

        // Tambahkan listener klik untuk imageView5
        val imageView112: ImageView = findViewById(R.id.imageView112)
        imageView112.setOnClickListener {
            // Panggil metode untuk kembali ke MainActivity2
            navigateToMainActivity2()
        }

        // Panggil metode untuk memperbarui data dari URL secara periodik
        updateDataFromUrlPeriodically()
    }

    private fun updateDataFromUrlPeriodically() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            @SuppressLint("SetTextI18n")
            override fun run() {
                // Ganti dengan pemanggilan metode untuk mendapatkan data dummy
                updateDummyData()

                // Atur pengulangan setiap detik
                handler.postDelayed(this, 1000)
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun updateDummyData() {
        // Mendapatkan data dummy
        val waterflow1 = generateDummyData()
        val waterflow2 = generateDummyData()
        val waterflow3 = generateDummyData()
        val waterflow4 = generateDummyData()
        val waterflow5 = generateDummyData()
        val waterflow6 = generateDummyData()
        val waterflow7 = generateDummyData()
        val waterflow8 = generateDummyData()
        val waterflow9 = generateDummyData()
        val waterflow10 = generateDummyData()
        val waterflow11 = generateDummyData()
        val waterflow12 = generateDummyData()

        // Tampilkan data di TextView
        textView1.text = String.format("%.1f L/H", waterflow1)
        textView2.text = String.format("%.1f L/H", waterflow2)
        textView3.text = String.format("%.1f L/H", waterflow3)
        textView4.text = String.format("%.1f L/H", waterflow4)
        textView5.text = String.format("%.1f L/H", waterflow5)
        textView6.text = String.format("%.1f L/H", waterflow6)
        textView7.text = String.format("%.1f L/H", waterflow7)
        textView8.text = String.format("%.1f L/H", waterflow8)
        textView9.text = String.format("%.1f L/H", waterflow9)
        textView10.text = String.format("%.1f L/H", waterflow10)
        textView11.text = String.format("%.1f L/H", waterflow11)
        textView12.text = String.format("%.1f L/H", waterflow12)
    }

    private fun generateDummyData(): Float {
        // Menghasilkan bilangan desimal acak sebagai data dummy
        return Random.nextFloat() * 100
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
        finish()  // Optional, untuk menutup MainActivity8 setelah berpindah ke MainActivity2
    }
}
