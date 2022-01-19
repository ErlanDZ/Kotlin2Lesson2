package com.example.kotlin2lesson2.data.repository.topnews

import com.example.kotlin2lesson2.common.base.BaseRepository
import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.data.remote.apiservice.NewsApiService
import com.example.kotlin2lesson2.data.remote.dtos.news.toDomain
import com.example.kotlin2lesson2.domain.model.News
import com.example.kotlin2lesson2.domain.repository.topNews.TopNewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopNewsRepositoriesImpl @Inject constructor(
    private val service: NewsApiService,
) : BaseRepository(), TopNewsRepository {

    private var positionPageSize: Int = 20
    private var positionPage: Int = 1

    override fun fetchTopNewsRepository(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
    ): Flow<Resource<List<News>>> = doRequest {
        service.fetchTopNews(
            "ff5055382de94f40acc1f10f5b414619",
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