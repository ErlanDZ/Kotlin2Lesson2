package com.example.data.remote.apiservice

import com.example.data.remote.dtos.news.NewsDto
import com.example.data.remote.dtos.news.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v2/top-headlines")
    suspend fun fetchTopNews(
        @Query("apiKey") apiKey: String?,
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("sources") sources: String?,
        @Query("q") q: String?,
        @Query("pageSize") pageSize: Int?,
        @Query("page") page: Int?,
    ): NewsResponseDto<NewsDto>
}