package com.dmendano.movies.di

import android.app.Application
import com.dmendano.data.di.ApiKey
import com.dmendano.data.local.MoviesLocalDataSource
import com.dmendano.data.remote.MoviesService
import com.dmendano.data.repositories.MoviesRepositoryImpl
import com.dmendano.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient =
        HttpLoggingInterceptor().run {
            level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder().addInterceptor(this).build()
        }

    @Provides
    @Singleton
    @ApiUrl
    fun provideApiUrl(): String = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    @com.dmendano.data.di.ApiKey
    fun provideApiKey(app: Application): String = "428f5001894ce61ed09cfd9f2c4f8aef"

    @Provides
    @Singleton
    fun providesRemoteService(
        @ApiUrl apiUrl: String,
        okHttpClient: OkHttpClient
    ): com.dmendano.data.remote.MoviesService =
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

    @Provides
    @Singleton
    fun providesMoviesRepository(
        @ApiKey apiKey: String,
        service: MoviesService,
        localDataSource: MoviesLocalDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(apiKey, service, localDataSource)
    }
}