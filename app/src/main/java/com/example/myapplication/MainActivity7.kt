package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity7 : AppCompatActivity() {

    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var textViewTime: TextView
    private lateinit var textViewDate: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7) // Adding TextView ID
        textViewTime = findViewById(R.id.textViewTime)
        textViewDate = findViewById(R.id.textViewDate)

        // Run the function to update time and date every second
        updateDateTime()

        // Add click listener for imageView28
        val imageView21: ImageView = findViewById(R.id.imageView28)
        imageView21.setOnClickListener {
            // Call the method to go back to MainActivity2
            navigateToMainActivity2()
        }

        // Call the method to update dummy data periodically
        updateDummyDataPeriodically()
    }

    private fun updateDummyDataPeriodically() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            @SuppressLint("SetTextI18n")
            override fun run() {
                // Generate dummy data
                val dummyData1 = generateDummyData()
                val dummyData2 = generateDummyData()
                val dummyData3 = generateDummyData()
                val dummyData4 = generateDummyData()

                // Display dummy data in TextView
                textView4.text = "$dummyData1 gr"
                textView5.text = "$dummyData2 gr"
                textView6.text = "$dummyData3 gr"
                textView7.text = "$dummyData4 gr"

                // Repeat every second
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun generateDummyData(): String {
        // Implementasi logika penghasilan data dummy sesuai kebutuhan Anda
        // Di sini, saya menggunakan angka acak antara 0 dan 100 untuk "weight"
        val randomWeight = (Math.random() * 100).toInt() / 10.0
        val decimalFormat = DecimalFormat("0.00")
        return decimalFormat.format(randomWeight)
    }

    private fun updateDateTime() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            @SuppressLint("SetTextI18n")
            override fun run() {
                // Format time and date
                val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

                // Get current time and date
                val calendar = Calendar.getInstance()
                val time = timeFormat.format(calendar.time)
                val date = dateFormat.format(calendar.time)

                // Display time and date in TextView
                textViewTime.text = "Waktu      : $time"
                textViewDate.text = "Tanggal   : $date"

                // Repeat every second
                handler.postDelayed(this, 1000)
            }
        })
    }

    // Method to go back to MainActivity2
    private fun navigateToMainActivity2() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        finish()  // Optional, to close MainActivity3 after moving to MainActivity2
    }
}
