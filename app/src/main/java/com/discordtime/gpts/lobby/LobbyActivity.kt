package com.discordtime.gpts.lobby

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import com.discordtime.gpts.R
import com.discordtime.gpts.listplaces.view.ListPlacesFragment
import com.discordtime.gpts.tools.Constants.TAG_LIST_PLACE_FRAGMENT
import kotlinx.android.synthetic.main.activity_lobby.*

class LobbyActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar
    private val fragmentListPlaces = ListPlacesFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active = fragmentListPlaces

    private lateinit var textMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        toolbar = supportActionBar!!
        toolbar.title = "Map"

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        initComponents()
    }

    private fun initComponents() {
        fm.beginTransaction().add(R.id.container,
            fragmentListPlaces, TAG_LIST_PLACE_FRAGMENT)
            .hide(fragmentListPlaces).commit()

    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_map -> {
                toolbar.title = "Map"
                textMessage.setText("Fragment 1")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list_places -> {
                toolbar.title = "List Places"
                fm.beginTransaction().show(fragmentListPlaces).commit()
                active = fragmentListPlaces
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.title = "Profile"
                textMessage.setText("Fragment 3")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
