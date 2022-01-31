package com.example.data.repository.everthing


import com.example.domain.common.resource.Resource
import com.example.data.remote.apiservice.EverythingApiService
import com.example.data.remote.dtos.news.toDomain
import com.example.domain.model.News
import com.example.data.repository.base.BaseRepository
import com.example.domain.repository.everthing.EverythingRepositories
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EverythingRepositoriesImpl @Inject constructor(
    private val service: EverythingApiService,
) : BaseRepository(), EverythingRepositories {

    private var positionPageSize: Int = 100

    override fun fetchNewsEverythingRepositories(
        q: String?,
        from: String?,
        to: String?,
        sortBy: String?,
        qInTitle: String,
        sources: String,
        domains: String,
        excludeDomains: String,
    ): Flow<Resource<List<News>>> = doRequest {
        service.fetchEverything(
            "393ed9c67e7e46548ad8f15d5694fea0",
            q,
            from,
            to,
            sortBy,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            positionPageSize,
        ).article.map { it.toDomain() }
    }
}