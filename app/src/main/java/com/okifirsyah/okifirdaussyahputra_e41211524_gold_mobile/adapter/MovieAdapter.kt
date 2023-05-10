package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.MovieListItem
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ItemMovieBinding

class MovieAdapter(private val listMovie: ArrayList<MovieListItem>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}