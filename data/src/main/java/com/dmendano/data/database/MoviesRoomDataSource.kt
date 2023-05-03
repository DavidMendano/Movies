package com.dmendano.data.database

import com.dmendano.data.local.MoviesLocalDataSource
import com.dmendano.data.models.MovieModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRoomDataSource @Inject constructor(
    private val moviesDao: MoviesDao
) : MoviesLocalDataSource {

    override val movies: Flow<List<MovieModel>>
        get() = moviesDao.getAll()

    override suspend fun insertAll(movies: List<MovieModel>) {
        moviesDao.insertMovies(movies)
    }
}