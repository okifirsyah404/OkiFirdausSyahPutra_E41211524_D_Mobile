package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.APIClient
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.interfaces.TMDBApiInterface
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.model.MovieResult
import kotlinx.coroutines.launch

class ListMovieViewModel : ViewModel() {
    fun getMovieList(): LiveData<MovieResult> {
        val tmdbApi = APIClient.getInstance().create(TMDBApiInterface::class.java)
        var result = MutableLiveData<MovieResult>()
        viewModelScope.launch {
            val response = tmdbApi.getTrendingMovies()
            Log.d("response", response.toString())
            if (response.results != null) {
                result.postValue(response)
            }
        }
        return result
    }
}