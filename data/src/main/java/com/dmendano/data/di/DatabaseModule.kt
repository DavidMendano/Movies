package com.dmendano.data.di

import android.app.Application
import androidx.room.Room
import com.dmendano.data.database.MoviesDao
import com.dmendano.data.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesMoviesDatabase(app: Application): MoviesDatabase =
        Room.databaseBuilder(
            app,
            MoviesDatabase::class.java,
            "movies-db"
        ).build()


    @Provides
    @Singleton
    fun providesMoviesDao(db: MoviesDatabase): MoviesDao = db.moviesDao()
}