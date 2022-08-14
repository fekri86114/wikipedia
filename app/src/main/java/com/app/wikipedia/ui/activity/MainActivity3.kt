package com.app.wikipedia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.wikipedia.R
import com.app.wikipedia.databinding.ActivityMain3Binding
import com.bumptech.glide.Glide

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgUrl = R.drawable.img_translatore

        Glide
            .with(this)
            .load( imgUrl )
            .into(binding.imgBeTranslater)

    }
}