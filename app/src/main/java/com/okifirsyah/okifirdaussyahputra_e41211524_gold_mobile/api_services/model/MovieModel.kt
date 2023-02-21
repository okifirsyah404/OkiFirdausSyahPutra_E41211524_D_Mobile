package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.api_services.model

import com.google.gson.annotations.SerializedName;

data class MovieResult (
    @SerializedName("page")
    val page: Long,

    @SerializedName("results")
    val results: List<Movie>,

    @SerializedName("total_pages")
    val totalPages: Long,

    @SerializedName("total_results")
    val totalResults: Long
)

data class Movie (
    @SerializedName("adult")
    val adult: Boolean,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("original_language")
    val originalLanguage: OriginalLanguage,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("media_type")
    val mediaType: MediaType,

    @SerializedName("genre_ids")
    val genreIDS: List<Long>,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("video")
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Long
)

enum class MediaType {
    Movie
}

enum class OriginalLanguage {
    En,
    Ko
}
