package com.dmendano.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmendano.data.models.MovieModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Query("SELECT * FROM MovieModel")
    fun getAll(): Flow<List<MovieModel>>

    @Query("SELECT * FROM MovieModel WHERE id = :id")
    fun findById(id: Int): Flow<MovieModel>

    @Query("SELECT COUNT(id) FROM MovieModel")
    suspend fun movieCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: MovieModel)

}
