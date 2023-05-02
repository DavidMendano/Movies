package com.dmendano.movies.di

import android.app.Application
import com.dmendano.common_ui.R
import com.dmendano.home_data.di.ApiKey
import com.dmendano.home_data.remote.MoviesService
import com.dmendano.home_data.repositories.MoviesRepositoryImpl
import com.dmendano.home_domain.repositories.MoviesRepository
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
    @ApiKey
    fun provideApiKey(app: Application): String = app.getString(R.string.api_key)

    @Provides
    @Singleton
    fun providesRemoteService(@ApiUrl apiUrl: String, okHttpClient: OkHttpClient): MoviesService =
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

    @Provides
    @Singleton
    fun providesMoviesRepository(@ApiKey apiKey: String, service: MoviesService): MoviesRepository {
        return MoviesRepositoryImpl(apiKey, service)
    }
}