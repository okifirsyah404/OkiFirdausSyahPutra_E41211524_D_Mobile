package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.gps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
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
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentGpsMapsBinding
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.utils.getDistance
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.utils.showOKDialog

class GpsMapsFragment : Fragment() {


    private var _gpsMapsFragment: FragmentGpsMapsBinding? = null
    private val binding get() = _gpsMapsFragment
    private lateinit var _viewModel: GpsMapsViewModel

    private lateinit var _map: GoogleMap
    private lateinit var _marker: Marker

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var userLocation: LatLng = LatLng(0.0, 0.0)
    private var pinnedPosition: Location? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _gpsMapsFragment = FragmentGpsMapsBinding.inflate(inflater, container, false)
        return _gpsMapsFragment?.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _gpsMapsFragment = FragmentGpsMapsBinding.bind(view)

        _viewModel = ViewModelProvider(this)[GpsMapsViewModel::class.java]

        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        fusedLocationClient =
            LocationServices.getFusedLocationProviderClient(requireActivity().applicationContext)
        createMap()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _gpsMapsFragment = null
    }

    private fun createMap() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_container) as SupportMapFragment?
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

                    val distance = userLocation.getDistance(
                        LatLng(
                            _marker.position.latitude,
                            _marker.position.longitude
                        )
                    )
                    binding?.tvDistance?.text = "Radial Distance: $distance"
                    binding?.tvLatitude?.text = "Latitude: ${userLocation.latitude}"
                    binding?.tvLongitude?.text = "Longitude: ${userLocation.longitude}"

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

                    val distance = userLocation.getDistance(it)
                    binding?.tvDistance?.text = "Radial Distance: $distance"
                    binding?.tvLatitude?.text = "Latitude: ${it.latitude}"
                    binding?.tvLongitude?.text = "Longitude: ${it.longitude}"

                }

            }


        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                // Precise location access granted.
            }

            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {

            }

            else -> {
                requireActivity().showOKDialog(
                    "Permission Required",
                    "Please allow location permission to use this feature"
                )
            }
        }
    }


}