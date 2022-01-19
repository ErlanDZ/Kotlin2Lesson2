package com.example.kotlin2lesson2.domain.repository.everthing

import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.domain.model.News
import kotlinx.coroutines.flow.Flow

interface EverythingRepositories {
    fun fetchNewsEverythingRepositories(
        q: String?,
        from: String?,
        to: String?,
        sortBy: String?,
        qInTitle: String,
        sources: String,
        domains: String,
        excludeDomains: String,
    ): Flow<Resource<List<News>>>
}