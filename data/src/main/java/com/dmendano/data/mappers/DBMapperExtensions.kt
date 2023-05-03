package com.dmendano.data.mappers

import com.dmendano.data.models.MovieModel
import com.dmendano.domain.models.MovieApiModel

fun List<MovieApiModel>.fromDomainModel() = map(MovieApiModel::fromDomainModel)

fun MovieApiModel.fromDomainModel(): MovieModel =
    MovieModel(
        id = id,
        overview = overview,
        releaseDate = releaseDate,
        posterPath = posterPath,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        title = title,
        popularity = popularity,
        voteAverage = voteAverage,
        favourite = false
    )

fun List<MovieModel>.toDomainModel() = map(MovieModel::toDomainModel)

fun MovieModel.toDomainModel(): MovieApiModel =
    MovieApiModel(
        id = id,
        overview = overview,
        releaseDate = releaseDate,
        posterPath = posterPath,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        title = title,
        popularity = popularity,
        voteAverage = voteAverage,
        favourite = false
    )
