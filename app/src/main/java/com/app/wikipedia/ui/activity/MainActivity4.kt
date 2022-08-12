package com.app.wikipedia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.wikipedia.R
import com.app.wikipedia.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.chipMachine.setOnCheckedChangeListener { buttonView, isChecked ->
//
//            if (isChecked) {
//
//                Toast.makeText(this, "Chip is checked!", Toast.LENGTH_SHORT).show()
//
//            } else {
//
//                Toast.makeText(this, "Chip is not checked!", Toast.LENGTH_SHORT).show()
//
//            }
//
//        }

        binding.chipGroupMain.setOnCheckedChangeListener { group, checkedIds -> // used it for understand witch of them is using.

            when ( checkedIds ) {

                R.id.chip_android -> {

                    Toast.makeText(this, "Android Checked!", Toast.LENGTH_SHORT).show()

                }

            }

        }

    }
}