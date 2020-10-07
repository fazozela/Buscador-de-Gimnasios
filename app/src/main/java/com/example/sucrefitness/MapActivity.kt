package com.example.sucrefitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity()  {

    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        mapFragment = supportFragmentManager.findFragmentById(R.id.frag_map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
//            googleMap.isMyLocationEnabled = true

            val location1 = LatLng(-19.050346, -65.252240)
            googleMap.addMarker(MarkerOptions().position(location1).title("Go Fit"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,14f))

            val location2 = LatLng(-19.044804, -65.251918)
            googleMap.addMarker(MarkerOptions().position(location2).title("Tiburon"))

            val location3 = LatLng(-19.046478,-65.242322)
            googleMap.addMarker(MarkerOptions().position(location3).title("Megatlon"))

            val location4 = LatLng(-19.0455,-65.242)
            googleMap.addMarker(MarkerOptions().position(location4).title("Gym Shark"))

            val location5 = LatLng(-19.043,-65.241)
            googleMap.addMarker(MarkerOptions().position(location5).title("Titanes"))
        })

    }


}