package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.adapter.GridMovieAdapter
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.APIClient
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.interfaces.TMDBApiInterface
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityGridRecyclerViewBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GridRecyclerViewActivity : AppCompatActivity() {

    lateinit var activityBinding: ActivityGridRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        activityBinding = ActivityGridRecyclerViewBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(activityBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Grid RecyclerView"

        activityBinding.rvGrid.setHasFixedSize(true)

        val tmdbApi = APIClient.getInstance().create(TMDBApiInterface::class.java)

        activityBinding.rvGrid.layoutManager =
            androidx.recyclerview.widget.GridLayoutManager(this, 2)

        GlobalScope.launch {
            val response = tmdbApi.getTrendingMovies()
            Log.d("response", response.toString())
            if (response.results != null) {
                this@GridRecyclerViewActivity.runOnUiThread(Runnable {
                    activityBinding.rvGrid.adapter = GridMovieAdapter(response)
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