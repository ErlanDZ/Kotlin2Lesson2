package com.example.kotlin2lesson2.domain.usecase.topNews

import com.example.kotlin2lesson2.domain.repository.topNews.TopNewsRepository
import javax.inject.Inject

class FetchBusinessUseCase @Inject constructor(
    private val repository: TopNewsRepository
) {
    operator fun invoke() = repository.fetchBusinessHeadlinesFromGermany()
}