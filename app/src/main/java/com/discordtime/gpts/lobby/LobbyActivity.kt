package com.discordtime.gpts.lobby

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.discordtime.gpts.R
import com.discordtime.gpts.listplaces.view.ListPlacesFragment
import com.discordtime.gpts.tools.Constants.TAG_LIST_PLACE_FRAGMENT
import kotlinx.android.synthetic.main.activity_lobby.*
import androidx.fragment.app.Fragment
import com.discordtime.gpts.profile.ProfileFragment
import com.discordtime.gpts.tools.Constants.TAG_PROFILE_FRAGMENT
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class LobbyActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar
    private val fragmentListPlaces = ListPlacesFragment()
    private var profileFragment = ProfileFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentListPlaces


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        toolbar = supportActionBar!!
        toolbar.title = "Map"

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        initComponents()
    }

    private fun initComponents() {
        fm.beginTransaction().add(
            R.id.container, fragmentListPlaces, TAG_LIST_PLACE_FRAGMENT)
            .hide(fragmentListPlaces).commit()

        fm.beginTransaction().add(R.id.container, profileFragment, TAG_PROFILE_FRAGMENT)
            .hide(profileFragment).commit()
    }

    private val onNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_map -> {
                toolbar.title = "Map"
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list_places -> {
                toolbar.title = "List Places"
                fm.beginTransaction().hide(active).show(fragmentListPlaces).commit()
                active = fragmentListPlaces
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.title = "Profile"
                fm.beginTransaction().hide(active).show(profileFragment).commit()
                active = profileFragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}