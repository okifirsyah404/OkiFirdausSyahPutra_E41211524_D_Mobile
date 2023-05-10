package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _homeFragmentBinding: FragmentHomeBinding? = null
    private val binding get() = _homeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _homeFragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return _homeFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _homeFragmentBinding = FragmentHomeBinding.bind(view)

        _homeFragmentBinding?.btnMapsGps?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_gpsMapsFragment)
        }

        _homeFragmentBinding?.btnLightSensor?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_lightSensorFragment)
        }

        _homeFragmentBinding?.btnProximitySensor?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_proximitySensorFragment)
        }

        _homeFragmentBinding?.btnTmdb?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_moavieListFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _homeFragmentBinding = null
    }
}