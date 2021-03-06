package com.example.domain.repository.topNews

import com.example.domain.common.resource.Resource
import com.example.domain.model.News
import kotlinx.coroutines.flow.Flow

interface TopNewsRepository {

    fun fetchTopNewsRepository(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
        page: Int
    ): Flow<Resource<List<News>>>
}