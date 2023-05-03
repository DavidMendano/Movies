package com.dmendano.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dmendano.data.models.MovieModel

@Database(entities = [MovieModel::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao
}