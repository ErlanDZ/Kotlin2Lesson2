package com.example.kotlin2lesson2.domain.usecase.everything

import com.example.kotlin2lesson2.domain.repository.everthing.EverythingRepositories
import javax.inject.Inject

class FetchNewsEverythingUseCase @Inject constructor(
    private val repositories: EverythingRepositories,
) {
    operator fun invoke(
        q: String?,
        from: String?,
        to: String?,
        sortBy: String?,
        qInTitle: String,
        sources: String,
        domains: String,
        excludeDomains: String,
    ) = repositories.fetchNewsEverythingRepositories(
        q, from, to, sortBy, qInTitle, sources, domains, excludeDomains
    )
}