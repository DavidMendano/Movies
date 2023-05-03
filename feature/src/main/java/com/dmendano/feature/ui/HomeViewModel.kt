package com.dmendano.feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmendano.domain.models.MovieApiModel
import com.dmendano.domain.models.MovieUiModel
import com.dmendano.domain.usecases.GetPopularMoviesUseCase
import com.dmendano.domain.usecases.RequestPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val requestPopularMoviesUseCase: RequestPopularMoviesUseCase,
    getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    val movies: Flow<List<MovieUiModel>> = getPopularMoviesUseCase()

    init {
        viewModelScope.launch { requestPopularMoviesUseCase("ES") }
    }
}