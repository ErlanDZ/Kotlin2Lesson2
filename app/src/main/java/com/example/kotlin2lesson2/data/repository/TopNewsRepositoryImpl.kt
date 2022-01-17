package com.example.kotlin2lesson2.data.repository

import com.example.kotlin2lesson2.common.base.BaseRepository
import com.example.kotlin2lesson2.data.remote.apiservice.NewsApiService
import com.example.kotlin2lesson2.data.remote.dtos.topnews.toDomain
import com.example.kotlin2lesson2.domain.repository.topNews.TopNewsRepository
import javax.inject.Inject

class TopNewsRepositoryImpl @Inject constructor(
    private val service: NewsApiService,
) : BaseRepository(), TopNewsRepository {

    override fun fetchTopNews() = doRequest {
        service.fetchTopNews()
            .article.map { it.toDomain() }
    }
}