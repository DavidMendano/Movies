package com.dmendano.domain.repositories

interface MoviesRepository {

    suspend fun getPopularMovies(region: String)
}
