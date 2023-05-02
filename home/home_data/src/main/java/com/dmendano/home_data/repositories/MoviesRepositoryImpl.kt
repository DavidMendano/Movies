package com.dmendano.home_data.repositories

import com.dmendano.home_data.di.ApiKey
import com.dmendano.home_domain.repositories.MoviesRepository
import com.dmendano.home_data.remote.MoviesService

class MoviesRepositoryImpl (
    @ApiKey private val apiKey: String,
    private val service: MoviesService
) : MoviesRepository {

    override suspend fun getPopularMovies(region: String) {
        service.getPopularMovies(apiKey, region)
    }
}