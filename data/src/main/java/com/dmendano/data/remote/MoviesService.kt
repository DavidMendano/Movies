package com.dmendano.data.remote

import com.dmendano.domain.models.MoviesApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("region") region: String
    ): MoviesApiModel

}