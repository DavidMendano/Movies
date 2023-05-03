package com.dmendano.domain.usecases

import com.dmendano.domain.models.MovieUiModel
import com.dmendano.domain.repositories.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    operator fun invoke(): Flow<List<MovieUiModel>> = repository.popularMovies
}