package com.example.kotlin2lesson2.domain.usecase.everything

import com.example.kotlin2lesson2.domain.repository.topNews.EverythingRepositories
import javax.inject.Inject

class FetchBitcoinRepositories @Inject constructor(
    private val repositories: EverythingRepositories
) {
    operator fun invoke() = repositories.fetchBitcoinRepositories()
}