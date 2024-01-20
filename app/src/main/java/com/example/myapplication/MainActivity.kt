package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView4: ImageView = findViewById(R.id.imageView4)
        imageView4.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        if (p0 !=null){
            when(p0.id){
                R.id.imageView4 ->{
                    val pindahIntent = Intent(this, MainActivity2::class.java)
                    startActivity(pindahIntent)
                }
            }
        }
    }
}