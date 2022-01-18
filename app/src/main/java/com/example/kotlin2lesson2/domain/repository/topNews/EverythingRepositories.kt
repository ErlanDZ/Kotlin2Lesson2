package com.example.kotlin2lesson2.domain.repository.topNews

import com.example.kotlin2lesson2.common.resource.Resource
import com.example.kotlin2lesson2.domain.model.News
import kotlinx.coroutines.flow.Flow

interface EverythingRepositories {

    fun fetchBitcoinRepositories(): Flow<Resource<List<News>>>

    fun fetchAppleRepositories(): Flow<Resource<List<News>>>

    fun fetchTechCrunchAndTheNextWebRepositories(): Flow<Resource<List<News>>>
}