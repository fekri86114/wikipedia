package com.app.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )
        setSupportActionBar( binding.toolbarMain ) // add actionbar

    }
}