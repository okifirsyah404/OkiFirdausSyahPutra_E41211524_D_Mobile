package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.adapter.ListMovieAdapter
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentListMovieBinding

class ListMovieFragment : Fragment() {

    companion object {
        fun newInstance() = ListMovieFragment()
    }

    private lateinit var viewModel: ListMovieViewModel
    private var _listMovieFragmentBinding: FragmentListMovieBinding? = null
    private val binding get() = _listMovieFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _listMovieFragmentBinding = FragmentListMovieBinding.inflate(inflater)
        return _listMovieFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _listMovieFragmentBinding = FragmentListMovieBinding.bind(view)

        binding?.rvList?.layoutManager = LinearLayoutManager(context)
        binding?.rvList?.adapter = ListMovieAdapter(viewModel.getMovieList().value!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        _listMovieFragmentBinding = null
    }

}