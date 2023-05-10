package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.maps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsViewModel : ViewModel() {
    fun getMarkerOptions(latitude: Double, longitude: Double, s: String): MarkerOptions {
        return MarkerOptions().position(LatLng(latitude, longitude)).title(s)
    }

    fun getCameraUpdate(latitude: Double, longitude: Double): CameraUpdate {
        return com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(
            LatLng(latitude, longitude), 15f
        )
    }

    val latitude = MutableLiveData<Double>()
    val longitude = MutableLiveData<Double>()


}