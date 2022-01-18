package com.example.kotlin2lesson2.data.repository.everthing

import com.example.kotlin2lesson2.common.base.BaseRepository
import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.data.remote.apiservice.EverythingApiService
import com.example.kotlin2lesson2.data.remote.dtos.topnews.toDomain
import com.example.kotlin2lesson2.domain.model.News
import com.example.kotlin2lesson2.domain.repository.topNews.EverythingRepositories
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EverythingRepositoriesImpl @Inject constructor(
    private val service: EverythingApiService,
) : BaseRepository(), EverythingRepositories {

    private var positionPageSize: Int = 20
    private var positionPage: Int = 1

    override fun fetchBitcoinRepositories(): Flow<Resource<List<News>>> = doRequest {
        service.fetchEverything(
            "ff5055382de94f40acc1f10f5b414619",
            "bitcoin",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            positionPage,
            positionPageSize
        )
            .article.map { it.toDomain() }
    }

    override fun fetchAppleRepositories(): Flow<Resource<List<News>>> = doRequest {
        service.fetchEverything(
            "ff5055382de94f40acc1f10f5b414619",
            "apple",
            "2022-01-16",
            "2022-01-16",
            "popularity",
            "",
            "",
            "",
            "",
            positionPage,
            positionPageSize
        )
            .article.map { it.toDomain() }
    }

    override fun fetchTechCrunchAndTheNextWebRepositories(): Flow<Resource<List<News>>> =
        doRequest {
            service.fetchEverything(
                "ff5055382de94f40acc1f10f5b414619",
                "",
                "",
                "",
                "",
                "",
                "",
                "techcrunch.com,thenextweb.com",
                "",
                positionPage,
                positionPageSize
            )
                .article.map { it.toDomain() }
        }
}