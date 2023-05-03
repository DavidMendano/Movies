package com.dmendano.data.repositories

import com.dmendano.data.di.ApiKey
import com.dmendano.data.local.MoviesLocalDataSource
import com.dmendano.data.remote.MoviesService
import com.dmendano.domain.mappers.toUiModel
import com.dmendano.domain.repositories.MoviesRepository
import kotlinx.coroutines.flow.map

class MoviesRepositoryImpl(
    @ApiKey private val apiKey: String,
    private val service: MoviesService,
    private val localDataSource: MoviesLocalDataSource
) : MoviesRepository {

    override val popularMovies get() = localDataSource.movies.map { it.toUiModel() }

    override suspend fun requestPopularMovies(region: String) {
        service.getPopularMovies(apiKey, region).also { movies ->
            localDataSource.insertAll(movies.results)
        }
    }
}
