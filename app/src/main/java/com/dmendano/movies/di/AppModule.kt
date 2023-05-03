package com.dmendano.movies.di

import com.dmendano.data.database.MoviesRoomDataSource
import com.dmendano.data.local.MoviesLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindsLocalDataSource(localDataSource: MoviesRoomDataSource): MoviesLocalDataSource
}