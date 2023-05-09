package com.dmendano.feature_favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmendano.domain.models.MovieUiModel
import com.dmendano.domain.usecases.GetFavouritesMoviesUseCase
import com.dmendano.domain.usecases.SwitchLikeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    getFavouritesUseCase: GetFavouritesMoviesUseCase,
    private val switchLikeUseCase: SwitchLikeUseCase
) : ViewModel() {
    var movies: MutableStateFlow<List<MovieUiModel>> = MutableStateFlow(listOf())

    init {
        viewModelScope.launch {
            getFavouritesUseCase.invoke().collect {
                movies.value = it
            }
        }
    }

    fun onLikeClicked(movie: MovieUiModel) {
        viewModelScope.launch { switchLikeUseCase(movie) }
    }
}