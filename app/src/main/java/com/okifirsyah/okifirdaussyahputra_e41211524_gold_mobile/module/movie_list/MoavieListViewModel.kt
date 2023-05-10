package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.movie_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.interfaces.TMDBApiInterfaces
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.MovieListItem
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.network.APIClient
import kotlinx.coroutines.launch

class MoavieListViewModel : ViewModel() {
    var movieList = MutableLiveData<ArrayList<MovieListItem>>()

    fun getMovieList() {
        viewModelScope.launch {
            val tmdbApi = APIClient.getInstance().create(TMDBApiInterfaces::class.java)

            val response = tmdbApi.getTrendingMovies()
            Log.d("response", response.toString())
            if (response.results != null) {
                movieList.postValue(response.results as ArrayList<MovieListItem>)
            }

            Log.d("response2", movieList.value.toString())
        }
    }


}