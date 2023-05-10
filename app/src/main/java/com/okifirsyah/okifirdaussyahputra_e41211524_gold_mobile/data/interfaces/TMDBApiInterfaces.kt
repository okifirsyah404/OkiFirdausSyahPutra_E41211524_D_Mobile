package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.interfaces

import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApiInterfaces {
    @GET("movie/popular")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = "9314f5af7d315717d1ac9ad906afc437"
    ): MovieListResponse
}