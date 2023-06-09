package com.dmendano.feature_favourites

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmendano.common.ui.MovieItem
import com.dmendano.feature_favourites.mappers.toItemModel

@Composable
fun FavouritesScreen(viewModel: FavouritesViewModel = hiltViewModel()) {
    val movies by viewModel.movies.collectAsState(initial = listOf())
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(movies) { movie ->
            MovieItem(movie = movie.toItemModel()) { viewModel.onLikeClicked(movie) }
        }
    }
}
