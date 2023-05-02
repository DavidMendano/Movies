package com.dmendano.home_domain.repositories

interface MoviesRepository {

    suspend fun getPopularMovies(region: String)
}
