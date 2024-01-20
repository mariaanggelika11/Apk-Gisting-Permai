package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val imageView9: ImageView = findViewById(R.id.imageView9)
        imageView9.setOnClickListener(this)

        val imageView10: ImageView = findViewById(R.id.imageView10)
        imageView10.setOnClickListener(this)

        val imageView11: ImageView = findViewById(R.id.imageView11)
        imageView11.setOnClickListener(this)

        val imageView12: ImageView = findViewById(R.id.imageView12)
        imageView12.setOnClickListener(this)

        val imageView13: ImageView = findViewById(R.id.imageView13)
        imageView13.setOnClickListener(this)

        val imageView14: ImageView = findViewById(R.id.imageView14)
        imageView14.setOnClickListener(this)  // Tambahkan ImageView14 dan setOnClickListener

        val imageView15: ImageView = findViewById(R.id.imageView15)
        imageView15.setOnClickListener(this)

        val imageView111: ImageView = findViewById(R.id.imageView111)
        imageView111.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.imageView9 -> {
                    val pindahIntent = Intent(this, MainActivity3::class.java)
                    startActivity(pindahIntent)
                }
                R.id.imageView10 -> {
                    val pindahIntent = Intent(this, MainActivity4::class.java)
                    startActivity(pindahIntent)
                }
                R.id.imageView11 -> {
                    val pindahIntent = Intent(this, MainActivity5::class.java)
                    startActivity(pindahIntent)
                }
                R.id.imageView12 -> {
                    val pindahIntent = Intent(this, MainActivity6::class.java)
                    startActivity(pindahIntent)
                }
                R.id.imageView13 -> {
                    val uri = Uri.parse("https://gh-fp.isi-net.org/dashboard.html#judul_grafik")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
                R.id.imageView14 -> {
                    val uri = Uri.parse("https://gh-fp.isi-net.org/dashboard.html#table-container")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
                R.id.imageView15 -> {
                    val pindahIntent = Intent(this, MainActivity7::class.java)
                    startActivity(pindahIntent)
                }
                R.id.imageView111 -> {
                    val pindahIntent = Intent(this, MainActivity8::class.java)
                    startActivity(pindahIntent)
                }
            }
        }
    }
}
