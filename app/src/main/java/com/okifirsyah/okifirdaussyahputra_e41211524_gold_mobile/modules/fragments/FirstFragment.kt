package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _firstFragmentBinding: FragmentFirstBinding? = null
    private val binding get() = _firstFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _firstFragmentBinding = FragmentFirstBinding.inflate(inflater)
        return _firstFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _firstFragmentBinding = FragmentFirstBinding.bind(view)

        binding?.btnShowFirstFragment?.setOnClickListener {
            Toast.makeText(context, "First Fragment", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _firstFragmentBinding = null
    }


}