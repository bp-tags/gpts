package com.discordtime.gpts.lobby

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.discordtime.gpts.R
import com.discordtime.gpts.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class LobbyActivity : AppCompatActivity() {

    private lateinit var toolbar: ActionBar

    private val onNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_map -> {
                toolbar.title = "Map"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list_places -> {
                toolbar.title = "List Places"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.title = "Profile"
                var profileFragment = ProfileFragment.newInstance()
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.screen, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        toolbar = supportActionBar!!
        toolbar.title = "Map"

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
