package com.example.kotlin2lesson2.data.remote.apiservice

import com.example.kotlin2lesson2.data.remote.dtos.topnews.NewsResponseDto
import com.example.kotlin2lesson2.data.remote.dtos.topnews.TopNewsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v2/top-headlines?country=us&apiKey=ff5055382de94f40acc1f10f5b414619")
    suspend fun fetchTopNews(
//        @Query("category") category: String?,
//        @Query("sources") sources: String?,
//        @Query("pageSize") pageSize: Int?,
//        @Query("page") page: Int?,
    ): NewsResponseDto<TopNewsDto>

    @GET("/v2/everything?q=bitcoin&apiKey=ff5055382de94f40acc1f10f5b414619")
    suspend fun fetchEverything(

    )
}