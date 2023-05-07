package com.dmendano.data.repositories

import com.dmendano.data.di.ApiKey
import com.dmendano.data.local.MoviesLocalDataSource
import com.dmendano.data.mappers.toDBModel
import com.dmendano.data.models.MovieModel
import com.dmendano.data.remote.MoviesService
import com.dmendano.domain.mappers.toUiModel
import com.dmendano.domain.models.MovieUiModel
import com.dmendano.domain.repositories.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    @ApiKey private val apiKey: String,
    private val service: MoviesService,
    private val localDataSource: MoviesLocalDataSource
) : MoviesRepository {

    override suspend fun getPopularMovies() = withContext(Dispatchers.IO) {
        localDataSource.getMovies().map { it.toUiModel() }
    }

    override suspend fun requestPopularMovies(region: String) {
        service.getPopularMovies(apiKey, region).also { movies ->
            localDataSource.insertAll(movies.results)
        }
    }

    override suspend fun switchLike(movie: MovieUiModel) {
        val movieDB = movie.copy(favourite = !movie.favourite).toDBModel()
        localDataSource.updateMovie(movieDB)
    }
}
