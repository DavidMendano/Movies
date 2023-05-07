package com.dmendano.domain.usecases

import com.dmendano.domain.models.MovieUiModel
import com.dmendano.domain.repositories.MoviesRepository
import javax.inject.Inject

class SwitchLikeUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(movie: MovieUiModel) =
        repository.switchLike(movie)
}