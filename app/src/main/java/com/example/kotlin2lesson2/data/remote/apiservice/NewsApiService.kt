package com.example.kotlin2lesson2.data.remote.apiservice

import com.example.kotlin2lesson2.data.remote.dtos.topnews.NewsResponseDto
import com.example.kotlin2lesson2.data.remote.dtos.topnews.NewsDto
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