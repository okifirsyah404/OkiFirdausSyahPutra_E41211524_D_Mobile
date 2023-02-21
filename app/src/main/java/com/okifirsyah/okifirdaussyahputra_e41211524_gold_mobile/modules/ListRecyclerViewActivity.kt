package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.adapter.ListMovieAdapter
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.APIClient
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.interfaces.TMDBApiInterface
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.model.MovieResult
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityListRecyclerViewBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListRecyclerViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityListRecyclerViewBinding
    lateinit var result: MovieResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "List RecyclerView"

        binding.rvList.setHasFixedSize(true)

        val tmdbApi = APIClient.getInstance().create(TMDBApiInterface::class.java)

        binding.rvList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        GlobalScope.launch{
            val response = tmdbApi.getTrendingMovies()
            Log.d("response", response.toString())
            if (response.results != null) {
                this@ListRecyclerViewActivity.runOnUiThread(Runnable {
                    binding.rvList.adapter = ListMovieAdapter(response)
                })
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}