package com.app.wikipedia.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.app.wikipedia.R
import com.app.wikipedia.databinding.ActivityMainBinding
import com.app.wikipedia.ui.fragments.ExploreFragment
import com.app.wikipedia.ui.fragments.PhotographerFragment
import com.app.wikipedia.ui.fragments.ProfileFragment
import com.app.wikipedia.ui.fragments.TrendFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain) // added actionbar

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolbarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationDrawerMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                //upstairs (Navigation drawer) -->
                R.id.menu_writer -> {
                    // set close drawer from left to right -->
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_photographer -> {
                    // load fragment -->
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container, PhotographerFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()

                    // check menu item -->
                    binding.navigationDrawerMain.menu.getItem(1).isCheckable = true
                    binding.navigationDrawerMain.menu.getItem(1).isChecked = true

                    // close drawer -->
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                }

                R.id.menu_video_maker -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_translater -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                // downstairs (Navigation drawer) -->
                R.id.menu_open_wikipedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_open_wikimedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

            }

            true
        }

        firstRun() // called first item for set selected

        binding.bottomNavigationMain.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragment(ExploreFragment())
                }
                R.id.menu_profile -> {
                    replaceFragment(ProfileFragment())
                }
                R.id.menu_trend -> {
                    replaceFragment(TrendFragment())
                }
            }

            // check menu item off -->
            binding.navigationDrawerMain.menu.getItem(1).isCheckable = false
            binding.navigationDrawerMain.menu.getItem(1).isChecked = false

            true
        }

        // set reselected to navigation. it doesn't let the application get any errors :-) you shouldn't give anything to this
        binding.bottomNavigationMain.setOnItemReselectedListener { }
    }

    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    fun firstRun() {
        replaceFragment(ExploreFragment())
        binding.bottomNavigationMain.selectedItemId =
            R.id.menu_explore // set selected an item in bottom navigation
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // check menu item off -->
        binding.navigationDrawerMain.menu.getItem(1).isCheckable = false
        binding.navigationDrawerMain.menu.getItem(1).isChecked = false
    }

}