package com.example.getgps4

import android.annotation.SuppressLint
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var fusedLocationClient: FusedLocationProviderClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        obtieneLocalizacion();
    }

    @SuppressLint("MissingPermission")
    private fun obtieneLocalizacion(){
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                var latitude = location?.latitude
                var longitude = location?.longitude

                Txt_Latitude.text = location?.latitude.toString()
                Txt_Longitude.text = location?.longitude.toString()

            }
    }
}