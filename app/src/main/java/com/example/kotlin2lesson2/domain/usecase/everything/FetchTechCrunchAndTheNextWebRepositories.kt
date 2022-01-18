package com.example.kotlin2lesson2.domain.usecase.everything

import com.example.kotlin2lesson2.domain.repository.topNews.EverythingRepositories
import javax.inject.Inject

class FetchTechCrunchAndTheNextWebRepositories @Inject constructor(
    private val repositories: EverythingRepositories
) {
    operator fun invoke() = repositories.fetchTechCrunchAndTheNextWebRepositories()
}