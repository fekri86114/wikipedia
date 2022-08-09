package com.app.wikipedia.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.app.wikipedia.R
import com.app.wikipedia.databinding.ActivityMainBinding
import com.app.wikipedia.ui.fragments.ExploreFragment
import com.app.wikipedia.ui.fragments.ProfileFragment
import com.app.wikipedia.ui.fragments.TrendFragment

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
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationDrawerMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                //upstairs (Navigation drawer) -->
                R.id.menu_writer -> {
                    // set close drawer from left to right -->
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)

                    dialog.titleText = "Alert!"
                    dialog.confirmText = "Confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Wanna be a writer?"

                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                    }

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                        Toast.makeText(this, "Confirmed!! You can be a writer!", Toast.LENGTH_SHORT)
                            .show()

                    }

                }

                R.id.menu_photographer -> {
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

                    //set badge
//                    var badge = binding.bottomNavigationMain.getOrCreateBadge(R.id.menu_explore)
//                    badge.isVisible = true
//                    badge.number = 122
                }
                R.id.menu_profile -> {
                    replaceFragment(ProfileFragment())
                }
                R.id.menu_trend -> {
                    replaceFragment(TrendFragment())
                }

            }

            true
        }

        // set reselected to navigation. it doesn't let the application get any errors :-) you shouldn't give anything to this
        binding.bottomNavigationMain.setOnItemReselectedListener {  }
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

}