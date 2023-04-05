package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.shared_preferences.SharedPreferenceManager
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private var binding: FragmentSignInBinding? = null
    val fragmentSignInBinding get() = binding!!

    lateinit var pref: SharedPreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return fragmentSignInBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = SharedPreferenceManager(requireContext())

        binding?.btnSignIn?.setOnClickListener {
            signIn()
        }

        binding?.btnNavSignUp?.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun signIn() {
        val username = pref.getStringPreferences("username")
        val password = pref.getStringPreferences("password")
        if (
            fragmentSignInBinding.edtInputUsername.editText?.text.toString().isNotEmpty() &&
            fragmentSignInBinding.edtInputPassword.editText?.text.toString().isNotEmpty()
        ) {

            if (
                username == fragmentSignInBinding.edtInputUsername.editText?.text.toString() &&
                password == fragmentSignInBinding.edtInputPassword.editText?.text.toString()
            ) {
                pref.setStringPreference(
                    "username",
                    fragmentSignInBinding.edtInputUsername.editText?.text.toString()
                )
                pref.setStringPreference(
                    "password",
                    fragmentSignInBinding.edtInputPassword.editText?.text.toString()
                )

                findNavController().navigate(R.id.action_signInFragment_to_dashboardFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Username or Password is wrong",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

        } else {
            Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT)
                .show()
        }
    }
}