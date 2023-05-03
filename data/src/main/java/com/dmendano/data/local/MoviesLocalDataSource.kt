package com.dmendano.data.local

import com.dmendano.data.models.MovieModel
import com.dmendano.domain.models.MovieApiModel
import kotlinx.coroutines.flow.Flow

interface MoviesLocalDataSource {

    val movies: Flow<List<MovieApiModel>>

    suspend fun insertAll(movies: List<MovieApiModel>)
}
