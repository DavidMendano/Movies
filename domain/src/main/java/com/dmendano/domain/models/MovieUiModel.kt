package com.dmendano.domain.models

data class MovieUiModel(
    val id: Int,

    val overview: String,

    val releaseDate: String,

    val posterPath: String,

    val backdropPath: String,

    val originalLanguage: String,

    val originalTitle: String,

    val title: String,

    val popularity: Double,

    val voteAverage: Double,

    val favourite: Boolean
)
