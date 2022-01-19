package com.example.kotlin2lesson2.domain.usecase.topNews

import com.example.kotlin2lesson2.domain.repository.topNews.TopNewsRepository
import javax.inject.Inject

class FetchTopNewsUseCase @Inject constructor(
    private val repository: TopNewsRepository,
) {
    operator fun invoke(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
    ) = repository.fetchTopNewsRepository(country, category, sources, q)
}