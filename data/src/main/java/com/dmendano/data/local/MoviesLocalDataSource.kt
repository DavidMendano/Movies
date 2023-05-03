package com.dmendano.data.local

import com.dmendano.data.models.MovieModel
import kotlinx.coroutines.flow.Flow

interface MoviesLocalDataSource {
    val movies: Flow<List<MovieModel>>

    suspend fun insertAll(movies: List<MovieModel>)
}