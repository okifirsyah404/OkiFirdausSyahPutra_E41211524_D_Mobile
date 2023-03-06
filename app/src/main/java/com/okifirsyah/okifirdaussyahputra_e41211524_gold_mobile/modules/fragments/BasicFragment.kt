package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentBasicBinding


class BasicFragment : Fragment() {

    private var _basicFragmentBinding: FragmentBasicBinding? = null
    private val binding get() = _basicFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _basicFragmentBinding = FragmentBasicBinding.inflate(inflater)
        return _basicFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _basicFragmentBinding = FragmentBasicBinding.bind(view)

        loadFragment(FirstFragment())

        binding?.btnFirstFragment?.setOnClickListener {
            loadFragment(FirstFragment())
        }

        binding?.btnSecondFragment?.setOnClickListener {
            loadFragment(SecondFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(binding?.basicFragmentContainer?.id!!, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _basicFragmentBinding = null
    }
}