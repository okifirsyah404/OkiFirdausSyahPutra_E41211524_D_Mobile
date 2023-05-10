package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.movie_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.adapter.MovieAdapter
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentMoavieListBinding

class MoavieListFragment : Fragment() {

    private var _binding: FragmentMoavieListBinding? = null
    val binding get() = _binding

    private lateinit var viewModel: MoavieListViewModel
    private val movieAdapter: MovieAdapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoavieListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MoavieListViewModel::class.java]
        viewModel.getMovieList()
        binding?.rvMovie?.layoutManager = GridLayoutManager(context, 2)
        initObserver()
    }

    private fun initObserver() {

        viewModel.movieList.observe(viewLifecycleOwner) {
            binding?.rvMovie?.adapter = movieAdapter
            movieAdapter.setData(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}