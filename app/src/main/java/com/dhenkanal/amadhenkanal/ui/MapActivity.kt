package com.dhenkanal.amadhenkanal.ui

import android.content.Intent
import android.location.GpsStatus
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dhenkanal.amadhenkanal.MainActivity
import com.dhenkanal.amadhenkanal.R
import com.dhenkanal.amadhenkanal.databinding.ActivityMapBinding
import com.google.android.gms.location.LocationListener
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback, GpsStatus.Listener, LocationListener,
GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener{

    private lateinit var binding: ActivityMapBinding

    private lateinit var mMap: GoogleMap


    var currLat: Double = 0.0
    var currLon: Double = 0.0
    var currAlt: Double = 0.0
    var currAcc: Double = 0.0
    var currSpeed: Double = 0.0
    var gpsDTM: Long = 0
    lateinit var mylm: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) // This will call onMapReady()

        binding.bottomNavigation.selectedItemId = R.id.nav_map

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_explore -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish() // close current activity
                    true
                }
                R.id.nav_map -> {
                    true
                }
                R.id.nav_famous -> {
                    startActivity(Intent(this, FamousActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish()
                    true
                }
                R.id.nav_more -> {
                    startActivity(Intent(this, MoreDetailsActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    finish()
                    true
                }
                else -> false
            }
        }


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Coordinates for Dhenkanal, Odisha
        val dhenkanalCoordinates = LatLng(20.6574, 85.5960)

        // Set camera to Dhenkanal
        val cameraPosition = CameraPosition.Builder()
            .target(dhenkanalCoordinates)
            .zoom(12f) // Closer zoom for city view
            .build()

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        // Add marker for Dhenkanal
        mMap.addMarker(
            MarkerOptions()
                .position(dhenkanalCoordinates)
                .title("Dhenkanal")
                .snippet("Dhenkanal District, Odisha")
        )

        mMap.setOnInfoWindowClickListener(this)
        mMap.setOnMarkerClickListener(this)
    }

    override fun onGpsStatusChanged(event: Int) {
        TODO("Not yet implemented")
    }

    override fun onMarkerClick(p0: Marker): Boolean {
        TODO("Not yet implemented")
    }

    override fun onInfoWindowClick(p0: Marker) {
        TODO("Not yet implemented")
    }

    override fun onLocationChanged(location: Location) {
        if (location != null) {
            currLat = location.latitude
            currLon = location.longitude
            currAlt = location.altitude
            currAcc = location.accuracy.toDouble()
            currSpeed = location.speed.toDouble()
            gpsDTM = location.time
        }
    }

}