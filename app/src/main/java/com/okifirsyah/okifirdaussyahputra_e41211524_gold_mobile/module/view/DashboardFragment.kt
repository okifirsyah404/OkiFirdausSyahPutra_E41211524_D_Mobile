package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.shared_preferences.SharedPreferenceManager
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {
    private var binding: FragmentDashboardBinding? = null
    val fragmentDashboardBinding get() = binding!!

    lateinit var pref: SharedPreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return fragmentDashboardBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = SharedPreferenceManager(requireContext())
        initDashboard()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initDashboard() {
        val username = pref.getStringPreferences("username")
        val lecture = pref.getStringPreferences("lecture")
        val userFullName = pref.getStringPreferences("user_full_name")

        fragmentDashboardBinding.tvSayHello.text =
            "Hallo $userFullName dari $lecture dengan username: $username."

        binding?.btnSignOut?.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_signInFragment)
        }

        binding?.btnDelete?.setOnClickListener {
            pref.clearPreferenceByKey("username")
            pref.clearPreferenceByKey("password")
            pref.clearPreferenceByKey("user_full_name")
            pref.clearPreferenceByKey("lecture")
            findNavController().navigate(R.id.action_dashboardFragment_to_signInFragment)
        }

    }

}