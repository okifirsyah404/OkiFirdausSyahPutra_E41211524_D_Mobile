package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _mainFragmentBinding: FragmentMainBinding? = null
    private val binding get() = _mainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mainFragmentBinding = FragmentMainBinding.inflate(inflater)
        return _mainFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _mainFragmentBinding = FragmentMainBinding.bind(view)

        _mainFragmentBinding?.btnBasicFragment?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_basicFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mainFragmentBinding = null
    }
}