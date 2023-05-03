package com.dmendano.data.repositories

import com.dmendano.data.di.ApiKey
import com.dmendano.data.local.MoviesLocalDataSource
import com.dmendano.data.remote.MoviesService
import com.dmendano.domain.repositories.MoviesRepository

class MoviesRepositoryImpl(
    @ApiKey private val apiKey: String,
    private val service: MoviesService,
    private val localDataSource: MoviesLocalDataSource
) : MoviesRepository {

    override suspend fun getPopularMovies(region: String) {
        service.getPopularMovies(apiKey, region).also {
            localDataSource.movies
        }
    }
}