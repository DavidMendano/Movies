package com.dmendano.home_domain.usecases

import com.dmendano.home_domain.repositories.MoviesRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) : suspend (String) -> Unit {

    override suspend fun invoke(region: String) {
        repository.getPopularMovies(region)
    }
}
