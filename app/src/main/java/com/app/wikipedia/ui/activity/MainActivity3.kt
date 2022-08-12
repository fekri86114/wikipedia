package com.app.wikipedia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.wikipedia.databinding.ActivityMain3Binding
import com.bumptech.glide.Glide

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgUrl = "https://www.mountainphotography.com/images/xl/20130728-Memminger-Sunset.jpg"

        Glide
            .with(this)
            .load( imgUrl )
            .into(binding.imgBeTranslater)

    }
}