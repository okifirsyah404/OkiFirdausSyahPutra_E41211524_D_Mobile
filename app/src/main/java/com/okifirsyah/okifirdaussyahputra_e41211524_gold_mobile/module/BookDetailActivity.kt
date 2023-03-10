package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Book
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityBookDetailBinding

class BookDetailActivity : AppCompatActivity() {

    private var _activityBookDetailBinding: ActivityBookDetailBinding? = null
    private val binding get() = _activityBookDetailBinding

    private var bookTitle: String = ""
    private var bookAuthor: String = ""

    companion object {
        const val EXTRA_BOOK = "extra_book"
    }

    private fun setData() {
        val book = intent.extras?.getParcelable<Book>(EXTRA_BOOK)

        _activityBookDetailBinding?.tvItemTitle?.text = book?.title
        _activityBookDetailBinding?.tvItemAuthor?.text = book?.author
        _activityBookDetailBinding?.tvItemPublisher?.text = book?.publisher
        _activityBookDetailBinding?.tvItemPages?.text = "${book?.pages} halaman"
        _activityBookDetailBinding?.tvItemDescription?.text = book?.description
        if (book != null) {
            _activityBookDetailBinding?.imgItemCover?.setImageResource(book.cover)
        }

        _activityBookDetailBinding?.tvItemSpecSubtitle?.text = book?.subtitle
        _activityBookDetailBinding?.tvItemAuthor?.text = book?.author
        _activityBookDetailBinding?.tvItemPublisher?.text = book?.publisher
        _activityBookDetailBinding?.tvItemSpecIsbn?.text = book?.isbn
        _activityBookDetailBinding?.tvItemPages?.text = "${book?.pages} halaman"
        _activityBookDetailBinding?.tvItemSpecGenre?.text = book?.genre
        _activityBookDetailBinding?.tvItemSpecPublishDate?.text = book?.publishDate
        _activityBookDetailBinding?.tvItemSpecLanguage?.text = book?.language

        bookTitle = book?.subtitle.toString()
        bookAuthor = book?.author.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityBookDetailBinding = ActivityBookDetailBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Buku"


        setData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_book, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        R.id.action_share -> {
            val shareIntent = Intent(Intent.ACTION_SEND).setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "$bookTitle by $bookAuthor")
            startActivity(Intent.createChooser(shareIntent, "Bagikan Dengan..."))
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}