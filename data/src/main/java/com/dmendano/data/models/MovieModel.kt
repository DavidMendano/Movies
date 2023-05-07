package com.dmendano.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieModel(

    @PrimaryKey
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
