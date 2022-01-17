package com.example.kotlin2lesson2.domain.repository.topNews

import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.domain.model.TopNews
import kotlinx.coroutines.flow.Flow

interface TopNewsRepository {
    fun fetchTopNews(): Flow<Resource<List<TopNews>>>
}