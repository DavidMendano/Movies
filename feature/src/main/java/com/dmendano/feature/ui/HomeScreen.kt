package com.dmendano.feature.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val movies by viewModel.movies.collectAsState(initial = listOf())
    LazyColumn {
        items(movies) { movie ->
            Text(movie.title)
        }
    }
}

@Composable
fun FavouritesScreen() {
    Text("Favourites screen")
}

@Composable
fun SearchScreen() {
    Text("Search screen")
}
