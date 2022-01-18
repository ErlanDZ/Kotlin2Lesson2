package com.example.kotlin2lesson2.domain.repository.topNews

import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.domain.model.News
import kotlinx.coroutines.flow.Flow

interface TopNewsRepository {

    fun fetchTopNewsRepository(): Flow<Resource<List<News>>>

    fun fetchBBCNewsRepository(): Flow<Resource<List<News>>>

    fun fetchBusinessHeadlinesFromGermany(): Flow<Resource<List<News>>>

    fun fetchHeadlinesAboutTrump(): Flow<Resource<List<News>>>
}