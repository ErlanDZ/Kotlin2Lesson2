package com.example.kotlin2lesson2.domain.usecase

import com.example.kotlin2lesson2.domain.repository.topNews.TopNewsRepository
import javax.inject.Inject

class FetchTopNewsUseCase @Inject constructor(
    private val repository: TopNewsRepository
) {
    operator fun invoke() = repository.fetchTopNews()
}