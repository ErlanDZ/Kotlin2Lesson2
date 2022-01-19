package com.example.kotlin2lesson2.data.repository.everthing

import android.util.Log
import com.example.kotlin2lesson2.common.base.BaseRepository
import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.data.remote.apiservice.EverythingApiService
import com.example.kotlin2lesson2.data.remote.dtos.news.toDomain
import com.example.kotlin2lesson2.domain.model.News
import com.example.kotlin2lesson2.domain.repository.everthing.EverythingRepositories
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EverythingRepositoriesImpl @Inject constructor(
    private val service: EverythingApiService,
) : BaseRepository(), EverythingRepositories {

    private var positionPageSize: Int = 20
    private var positionPage: Int = 1

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
            "ff5055382de94f40acc1f10f5b414619",
            q,
            from,
            to,
            sortBy,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            positionPage,
            positionPageSize
        )
            .article.map {
                it.toDomain()
            }
    }
}