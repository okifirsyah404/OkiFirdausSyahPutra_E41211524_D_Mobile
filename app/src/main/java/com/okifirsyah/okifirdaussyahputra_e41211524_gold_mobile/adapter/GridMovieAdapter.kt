package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.adapter

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.model.MovieResult
import java.util.*

class GridMovieAdapter(private val movieResult: MovieResult) :
    RecyclerView.Adapter<GridMovieAdapter.GridViewHolder>() {

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title) as TextView
        var tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author) as TextView
        var tvGenre: TextView = itemView.findViewById(R.id.tv_item_genre) as TextView
        var imgBookCover: ImageView = itemView.findViewById(R.id.img_item_cover) as ImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_grid_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movieResult.results.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val movie = movieResult.results[position]

        val dateFormat = SimpleDateFormat("yyyy-mm-dd")
        val dateTimeFormatter = SimpleDateFormat("dd MMMM yyyy", Locale("id"))


        holder.tvTitle.text = movie.title
        holder.tvAuthor.text = dateTimeFormatter.format(dateFormat.parse(movie.releaseDate))
        holder.tvGenre.text = "Pupularity ${movie.popularity}"

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .into(holder.imgBookCover)

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Kamu memilih " + movie.title,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}