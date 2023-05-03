package com.dmendano.domain.models

import com.google.gson.annotations.SerializedName

data class MoviesApiModel(

    @SerializedName("page")
    val page: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("results")
    val results: List<MovieApiModel>,

    @SerializedName("total_results")
    val totalResults: Int
)
