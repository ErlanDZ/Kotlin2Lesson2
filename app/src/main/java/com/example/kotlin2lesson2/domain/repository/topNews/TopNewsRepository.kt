package com.example.kotlin2lesson2.domain.repository.topNews

import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.data.remote.dtos.news.NewsResponseDto
import com.example.kotlin2lesson2.domain.model.News
import com.example.kotlin2lesson2.domain.model.Source
import kotlinx.coroutines.flow.Flow

interface TopNewsRepository {

    fun fetchTopNewsRepository(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
    ): Flow<Resource<List<News>>>
}