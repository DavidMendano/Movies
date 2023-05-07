package com.dmendano.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmendano.domain.models.MovieUiModel
import com.dmendano.domain.usecases.SwitchLikeUseCase
import com.dmendano.domain.usecases.GetPopularMoviesUseCase
import com.dmendano.domain.usecases.RequestPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val requestPopularMoviesUseCase: RequestPopularMoviesUseCase,
    private val switchLikeUseCase: SwitchLikeUseCase
) : ViewModel() {
    var movies: MutableStateFlow<List<MovieUiModel>> = MutableStateFlow(listOf())

    init {
        viewModelScope.launch {
            requestPopularMoviesUseCase.invoke("ES")
            getPopularMoviesUseCase.invoke().collect {
                movies.value = it
            }
        }
    }

    fun onLikeClicked(movie: MovieUiModel) {
        viewModelScope.launch { switchLikeUseCase(movie) }
    }
}