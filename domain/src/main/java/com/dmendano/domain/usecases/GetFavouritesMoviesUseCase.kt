package com.dmendano.domain.usecases

import com.dmendano.domain.models.MovieUiModel
import com.dmendano.domain.repositories.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouritesMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend fun invoke(): Flow<List<MovieUiModel>> = repository.getFavouritesMovies()
}