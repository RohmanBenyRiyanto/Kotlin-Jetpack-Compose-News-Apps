package com.learncompose.data.remote

import com.learncompose.data.remote.dto.NewsResponse
import com.learncompose.utils.Constants.NEWS_API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = NEWS_API_KEY,
    ) : NewsResponse
}