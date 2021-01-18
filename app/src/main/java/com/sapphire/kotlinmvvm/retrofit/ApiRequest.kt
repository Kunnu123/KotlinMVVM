package com.sapphire.kotlinmvvm.retrofit

import com.sapphire.kotlinmvvm.response.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {

    @GET("v2/everything/")
    fun getMovieArticles(
        @Query("q") query: String?,
        @Query("apikey") apiKey: String?
    ): Call<ArticleResponse?>?
}