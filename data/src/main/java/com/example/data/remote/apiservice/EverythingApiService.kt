package com.example.data.remote.apiservice

import com.example.data.remote.dtos.news.NewsDto
import com.example.data.remote.dtos.news.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("/v2/everything")
    suspend fun fetchEverything(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String?,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("sortBy") sortBy: String?,
        @Query("qInTitle") qInTitle: String,
        @Query("sources") sources: String,
        @Query("domains") domains: String,
        @Query("excludeDomains") excludeDomains: String,
        @Query("pageSize") pageSize: Int?,
//        @Query("page") page: Int?,
    ): NewsResponseDto<NewsDto>
}