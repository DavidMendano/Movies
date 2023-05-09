package com.dmendano.domain.repositories

import com.dmendano.domain.models.MovieUiModel
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getPopularMovies(): Flow<List<MovieUiModel>>

    suspend fun requestPopularMovies(region: String)

    suspend fun switchLike(movie: MovieUiModel)
}
