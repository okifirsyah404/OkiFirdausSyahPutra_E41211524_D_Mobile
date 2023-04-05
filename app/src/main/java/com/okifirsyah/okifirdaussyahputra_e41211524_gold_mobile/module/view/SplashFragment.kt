package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.shared_preferences.SharedPreferenceManager
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentSplashBinding
import timber.log.Timber

class SplashFragment : Fragment() {

    private var binding: FragmentSplashBinding? = null
    val fragmentSplashBinding get() = binding!!

    lateinit var pref: SharedPreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return fragmentSplashBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = SharedPreferenceManager(requireContext())

        initLoading()

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initLoading() {

        val usernamePref = pref.getStringPreferences("username")
        val passwordPref = pref.getStringPreferences("password")

        Handler(Looper.getMainLooper()).postDelayed({
            if (usernamePref.isNullOrBlank() && passwordPref.isNullOrBlank()) {
                Timber.tag("SplashFragment").d("usernamePref is null")
                findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
            } else {
                Timber.tag("SplashFragment").d("usernamePref: $usernamePref not null")
                findNavController().navigate(R.id.action_splashFragment_to_dashboardFragment)
            }
        }, 3000)
    }
}