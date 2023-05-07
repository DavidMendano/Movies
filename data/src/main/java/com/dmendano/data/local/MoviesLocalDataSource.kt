package com.dmendano.data.local

import com.dmendano.data.models.MovieModel
import com.dmendano.domain.models.MovieApiModel
import kotlinx.coroutines.flow.Flow

interface MoviesLocalDataSource {

    suspend fun getMovies(): Flow<List<MovieApiModel>>

    suspend fun insertAll(movies: List<MovieApiModel>)

    suspend fun updateMovie(movie: MovieModel)
}
