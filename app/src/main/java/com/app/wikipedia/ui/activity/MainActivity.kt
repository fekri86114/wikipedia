package com.app.wikipedia.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.app.wikipedia.R
import com.app.wikipedia.databinding.ActivityMainBinding
import com.app.wikipedia.databinding.FragmentExploreBinding
import com.app.wikipedia.ui.fragments.ExploreFragment
import com.app.wikipedia.ui.fragments.ProfileFragment
import com.app.wikipedia.ui.fragments.TrendFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )
        setSupportActionBar( binding.toolbarMain ) // add actionbar

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

            when ( it.itemId ) {

                //upstairs (Navigation drawer) -->
                R.id.menu_writer -> {

                    Toast.makeText(this, "menu_writer clicked!", Toast.LENGTH_SHORT).show()

                    // set close drawer from left to right -->
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

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

        firstRun() // called first item for set selected

        binding.bottomNavigationMain.setOnItemSelectedListener {

            when ( it.itemId ) {

                R.id.menu_explore -> {
                    replaceFragment( ExploreFragment() )

                    var badge = binding.bottomNavigationMain.getOrCreateBadge(R.id.menu_explore)
                    badge.isVisible = true
                    badge.number = 122

                }
                R.id.menu_profile -> {
                    replaceFragment( ProfileFragment() )
                }
                R.id.menu_trend -> {
                    replaceFragment( TrendFragment() )
                }

            }

            true
        }

        // set reselected to navigation. it doesn't let the application get any errors :-) you shouldn't give anything to this
        binding.bottomNavigationMain.setOnItemReselectedListener {  }

    }

    fun replaceFragment( fragment: Fragment ) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace( R.id.frame_main_container, fragment )
        transaction.commit()

    }

    fun firstRun() {

        replaceFragment( ExploreFragment() )
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore // set selected an item in bottom navigation

    }

}