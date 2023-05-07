package com.dmendano.domain.mappers

import com.dmendano.domain.models.MovieApiModel
import com.dmendano.domain.models.MovieUiModel

fun List<MovieApiModel>.toUiModel() = map(MovieApiModel::toUiModel)

fun MovieApiModel.toUiModel(): MovieUiModel =
    MovieUiModel(
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
        favourite = favourite
    )
