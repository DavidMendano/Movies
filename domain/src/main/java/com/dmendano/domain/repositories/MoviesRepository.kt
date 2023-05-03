package com.dmendano.domain.repositories

import com.dmendano.domain.models.MovieApiModel
import com.dmendano.domain.models.MovieUiModel
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    val popularMovies: Flow<List<MovieUiModel>>

    suspend fun requestPopularMovies(region: String)
}
