package com.example.data.repository.topnews

import com.example.domain.common.resource.Resource
import com.example.data.remote.apiservice.NewsApiService
import com.example.data.remote.dtos.news.toDomain
import com.example.domain.model.News
import com.example.data.repository.base.BaseRepository
import com.example.domain.repository.topNews.TopNewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopNewsRepositoriesImpl @Inject constructor(
    private val service: NewsApiService,
) : BaseRepository(), TopNewsRepository {

    private var positionPageSize: Int = 100

    override fun fetchTopNewsRepository(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
        page: Int
    ): Flow<Resource<List<News>>> = doRequest {
        service.fetchTopNews(
            "ed4cef1b46fc4c4b9bcbae4496fc2f58",
            country,
            category,
            sources,
            q,
            positionPageSize,
            page,
        )
            .article.map { it.toDomain() }
    }
}