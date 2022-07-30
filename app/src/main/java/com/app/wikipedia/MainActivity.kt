package com.app.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.app.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain) // add actionbar

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolbarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayoutMain.addDrawerListener( actionBarDrawerToggle )
        actionBarDrawerToggle.syncState()

        binding.navigationDrawerMain.setNavigationItemSelectedListener {

            when(it.itemId) {

                //upstairs (Navigation drawer) -->
                R.id.menu_writer -> {

                    Toast.makeText(this, "menu_writer clicked!", Toast.LENGTH_SHORT).show()

                    // set close drawer from left to right -->
                    binding.drawerLayoutMain.closeDrawer( GravityCompat.START )

                }
                R.id.menu_photographer -> {
                    Toast.makeText(this, "menu_photographer clicked!", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_video_maker -> {

                    Toast.makeText(this, "menu_video_maker  clicked!", Toast.LENGTH_SHORT).show()

                }
                R.id.menu_translater -> {

                    Toast.makeText(this, "menu_translater clicked!", Toast.LENGTH_SHORT).show()
                    
                }

                // downstairs (Navigation drawer) -->

                R.id.menu_open_wikipedia -> {

                    Toast.makeText(this, "menu_open_wikipedia clicked!", Toast.LENGTH_SHORT).show()
                    
                }
                R.id.menu_open_wikimedia -> {

                    Toast.makeText(this, "menu_open_wikimedia clicked!", Toast.LENGTH_SHORT).show()
                    
                }

            }

            true

        }

    }
}