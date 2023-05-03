package com.dmendano.data.database

import com.dmendano.data.local.MoviesLocalDataSource
import com.dmendano.data.mappers.fromDomainModel
import com.dmendano.data.mappers.toDomainModel
import com.dmendano.domain.models.MovieApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MoviesRoomDataSource @Inject constructor(
    private val moviesDao: MoviesDao
) : MoviesLocalDataSource {

    override val movies: Flow<List<MovieApiModel>>
        get() = moviesDao.getAll().map { it.toDomainModel() }

    override suspend fun insertAll(movies: List<MovieApiModel>) {
        moviesDao.insertMovies(movies.fromDomainModel())
    }
}