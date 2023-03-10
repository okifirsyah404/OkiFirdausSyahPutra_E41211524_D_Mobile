package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Book
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ItemGridBookBinding
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.BookDetailActivity

class GridBookAdapter(private val listBook: ArrayList<Book>) :
    RecyclerView.Adapter<GridBookAdapter.GridViewHolder>() {


    inner class GridViewHolder(private val binding: ItemGridBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            Glide.with(itemView.context)
                .load(book.cover)
                .into(binding.imgItemCover)

            binding.tvItemTitle.text = book.title
            binding.tvItemAuthor.text = book.author
            binding.tvItemGenre.text = book.genre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding =
            ItemGridBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val book = listBook[position]
        
        holder.bind(book)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BookDetailActivity::class.java)
            intent.putExtra(
                "extra_book",
                Book(
                    book.title,
                    book.subtitle,
                    book.author,
                    book.genre,
                    book.pages,
                    book.publisher,
                    book.isbn,
                    book.publishDate,
                    book.description,
                    book.cover,
                    book.language
                )
            )
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

    }


}