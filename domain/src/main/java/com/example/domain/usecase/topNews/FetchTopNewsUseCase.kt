package com.example.domain.usecase.topNews

import com.example.domain.repository.topNews.TopNewsRepository
import javax.inject.Inject

class FetchTopNewsUseCase @Inject constructor(
    private val repository: TopNewsRepository,
) {
    operator fun invoke(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
        page: Int,
    ) = repository.fetchTopNewsRepository(country, category, sources, q, page)
}