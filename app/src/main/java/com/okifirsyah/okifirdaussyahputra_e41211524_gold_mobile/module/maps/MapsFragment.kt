package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.maps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentMapsBinding
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.utils.showOKDialog
import java.util.Locale

class MapsFragment : Fragment() {

    private lateinit var _viewModel: MapsViewModel
    private lateinit var _map: GoogleMap
    private lateinit var _marker: Marker

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var userLocation: LatLng = LatLng(0.0, 0.0)

    private lateinit var _binding: FragmentMapsBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMapsBinding.bind(view)
        _viewModel = ViewModelProvider(this)[MapsViewModel::class.java]

        fusedLocationClient =
            LocationServices.getFusedLocationProviderClient(requireActivity().applicationContext)
        createMap()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun createMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync { googleMap ->

            googleMap.apply {
                if (parentFragment?.activity?.applicationContext?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    } != PackageManager.PERMISSION_GRANTED && parentFragment?.activity?.applicationContext?.let {
                        ActivityCompat.checkSelfPermission(
                            it,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                    } != PackageManager.PERMISSION_GRANTED
                ) {
                    requireContext().showOKDialog(
                        "Permission Required",
                        "Please allow location permission to use this feature"
                    )
                }
                isMyLocationEnabled = true
                fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    userLocation = LatLng(location.latitude, location.longitude)

                    _marker = addMarker(
                        _viewModel.getMarkerOptions(
                            userLocation.latitude,
                            userLocation.longitude,
                            "Pinned Location"
                        )
                    )!!

                    _viewModel.latitude.value = userLocation.latitude
                    _viewModel.longitude.value = userLocation.longitude

                    moveCamera(
                        _viewModel.getCameraUpdate(
                            userLocation.latitude,
                            userLocation.longitude
                        )
                    )
                }

                setOnMapClickListener {
                    _marker.remove()
                    _marker = addMarker(
                        _viewModel.getMarkerOptions(
                            it.latitude,
                            it.longitude,
                            "Pinned Location"
                        )
                    )!!

                    _viewModel.latitude.value = it.latitude
                    _viewModel.longitude.value = it.longitude

                }

            }


        }
    }

    private fun placeMarkerOnMap(location: LatLng) {
        val titleStr = getAddress(location)
        val markerOptions =
            _viewModel.getMarkerOptions(location.latitude, location.longitude, titleStr)
        _marker = _map.addMarker(markerOptions)!!
    }

    private fun getAddress(location: LatLng): String {
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val address: Address?
        var addressText = ""

        val addresses: List<Address>? =
            geocoder.getFromLocation(location.latitude, location.longitude, 1)

        if (addresses != null) {
            if (addresses.isNotEmpty()) {
                address = addresses[0]
                addressText = address.getAddressLine(0)
            } else {
                addressText = "its not appear"
            }
        }
        return addressText
    }

}