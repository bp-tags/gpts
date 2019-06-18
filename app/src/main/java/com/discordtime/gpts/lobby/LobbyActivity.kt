package com.discordtime.gpts.lobby

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.discordtime.gpts.R
import com.discordtime.gpts.listplaces.view.ListPlacesFragment
import com.discordtime.gpts.maps.view.MapViewFragment
import com.discordtime.gpts.tools.Constants.PERMISSION_REQUEST_LOCATION_CODE
import com.discordtime.gpts.tools.Constants.TAG_LIST_PLACE_FRAGMENT
import com.discordtime.gpts.tools.Constants.TAG_MAPS_FRAGMENT
import kotlinx.android.synthetic.main.activity_lobby.*

class LobbyActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar
    private val fragmentListPlaces = ListPlacesFragment()
    private val fragmentMaps = MapViewFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentListPlaces

    private lateinit var textMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)

        //sets up location permission
        setupPermissions()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        toolbar = supportActionBar!!
        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        initComponents()
    }

    private fun initComponents() {
        fm.beginTransaction().replace(R.id.container, fragmentMaps).commit()
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_map -> {
                toolbar.title = "Maps"
                fm.beginTransaction().replace(R.id.container, fragmentMaps).commit()
                active = fragmentMaps
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list_places -> {
                toolbar.title = "List Places"
                fm.beginTransaction().replace(R.id.container, fragmentListPlaces).commit()
                active = fragmentListPlaces
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                toolbar.title = "Profile"
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    //TODO check permissions
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_FINE_LOCATION)

        if (permission != PackageManager.PERMISSION_GRANTED)
            makeRequest()
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_REQUEST_LOCATION_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when(requestCode) {
            PERMISSION_REQUEST_LOCATION_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                } else {
                }
            }
        }
    }
}
