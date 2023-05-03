package com.dmendano.domain.usecases

import com.dmendano.domain.repositories.MoviesRepository
import javax.inject.Inject

class RequestPopularMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(region: String) {
        repository.requestPopularMovies(region)
    }
}
