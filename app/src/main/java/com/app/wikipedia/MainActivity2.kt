package com.app.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.app.wikipedia.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate( layoutInflater )
        setContentView( binding.root )
        setSupportActionBar( binding.toolbarMain2 )

        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor( this, android.R.color.transparent )
        )

        binding.collapsingMain.title = "Universe" // you can set title with this code! or at CollapsingToolbarLayout (xml) part with app:title="Universe"

        supportActionBar!!.setHomeButtonEnabled( true )
        supportActionBar!!.setDisplayHomeAsUpEnabled( true )

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if ( item.itemId == android.R.id.home ) {
            onBackPressed()
        }

        return true
    }

}