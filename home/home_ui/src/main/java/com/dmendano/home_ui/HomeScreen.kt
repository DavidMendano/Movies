package com.dmendano.home_ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val title by viewModel.title.collectAsState(initial = "")
    Text(title)
}

@Composable
fun FavouritesScreen() {
    Text("Favourites screen")
}

@Composable
fun SearchScreen() {
    Text("Search screen")
}
