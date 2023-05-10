package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.MovieListItem
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ItemMovieBinding

class MovieAdapter() :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie: ArrayList<MovieListItem> = ArrayList<MovieListItem>()
    fun setData(items: ArrayList<MovieListItem>) {
        listMovie.clear()
        listMovie.addAll(items)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        val binding = ItemMovieBinding.bind(holder.itemView)

        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(binding.imgItemCover)

        binding.tvItemTitle.text = movie.title
        binding.tvItemAuthor.text = movie.releaseDate
        binding.tvItemGenre.text = movie.overview
    }
}