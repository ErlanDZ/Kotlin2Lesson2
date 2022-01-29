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

    private var positionPageSize: Int = 10
    private var positionPage: Int = 1

    override fun fetchTopNewsRepository(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
    ): Flow<Resource<List<News>>> = doRequest {
        service.fetchTopNews(
            "393ed9c67e7e46548ad8f15d5694fea0",
            country,
            category,
            sources,
            q,
            positionPageSize,
            positionPage,
        )
            .article.map { it.toDomain() }
    }
}