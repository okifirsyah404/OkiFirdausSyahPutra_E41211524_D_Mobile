package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.utils

import android.location.Location
import com.google.android.gms.maps.model.LatLng


fun LatLng.getDistance(b: LatLng): String {
    val startPoint = Location("locationA")
    startPoint.latitude = this.latitude
    startPoint.longitude = this.longitude

    val endPoint = Location("locationB")
    endPoint.latitude = b.latitude
    endPoint.longitude = b.longitude

    var result = startPoint.distanceTo(endPoint)

    if (result > 1000) {
        result /= 1000
        return "${Math.round(result * 10.0) / 10.0} KM"

    }

    return "${Math.round(result * 10.0) / 10.0} M"
}