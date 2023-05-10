package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.movie_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentMoavieListBinding

class MoavieListFragment : Fragment() {

    private var _binding: FragmentMoavieListBinding? = null
    val binding get() = _binding

    private lateinit var viewModel: MoavieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoavieListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMoavieListBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}