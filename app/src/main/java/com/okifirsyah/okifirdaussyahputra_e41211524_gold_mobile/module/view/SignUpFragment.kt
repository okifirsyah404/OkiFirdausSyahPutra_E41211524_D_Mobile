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
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private var binding: FragmentSignUpBinding? = null
    val fragmentSignUpBinding get() = binding!!

    lateinit var pref: SharedPreferenceManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return fragmentSignUpBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = SharedPreferenceManager(requireContext())

        binding?.btnSignUp?.setOnClickListener {
            signUp()
        }

        binding?.btnNavSignIn?.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun signUp() {
        val username = fragmentSignUpBinding.edtInputUsername.editText?.text.toString()
        val password = fragmentSignUpBinding.edtInputPassword.editText?.text.toString()
        val lecture = fragmentSignUpBinding.edtInputLecture.editText?.text.toString()
        val userFullName = fragmentSignUpBinding.edtInputUserFullname.editText?.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty() && lecture.isNotEmpty()) {
            pref.setStringPreference("username", username)
            pref.setStringPreference("password", password)
            pref.setStringPreference("lecture", lecture)
            pref.setStringPreference("user_full_name", userFullName)
            findNavController().navigate(R.id.action_signUpFragment_to_dashboardFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT)
                .show()
        }
    }
}