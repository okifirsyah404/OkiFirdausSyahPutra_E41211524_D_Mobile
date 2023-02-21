package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.interfaces

import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.BuildConfig
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApiInterface {
    @GET("trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = "9314f5af7d315717d1ac9ad906afc437"
    ): MovieResult
}