package com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews

import com.example.domain.usecase.everything.FetchNewsEverythingUseCase
import com.example.domain.usecase.topNews.FetchTopNewsUseCase
import com.example.kotlin2lesson2.presentation.base.BaseViewModel
import com.example.kotlin2lesson2.presentation.model.NewsUI
import com.example.kotlin2lesson2.presentation.model.toUI
import com.example.kotlin2lesson2.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchTopNewsUseCase: FetchTopNewsUseCase,
    private val fetchNewsEverythingUseCase: FetchNewsEverythingUseCase,
) : BaseViewModel() {

    private val _topNewsState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val topNewsState: StateFlow<UIState<List<NewsUI>>> = _topNewsState

    private val _categoriesState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val categoriesState: StateFlow<UIState<List<NewsUI>>> = _categoriesState

    private val _newsEverythingState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val newsEverythingState: StateFlow<UIState<List<NewsUI>>> = _newsEverythingState

    private val _search = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val search: StateFlow<UIState<List<NewsUI>>> = _search


    fun fetchTopNews(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
    ) {
        _topNewsState.subscribeTo(
            { fetchTopNewsUseCase(country, category, sources, q) },
            { it.map { data -> data.toUI() } })
    }

    fun fetchCategories(
        country: String?,
        category: String?,
        sources: String?,
        q: String?,
    ) {
        _categoriesState.subscribeTo(
            { fetchTopNewsUseCase(country, category, sources, q) },
            { it.map { data -> data.toUI() } })
    }

    fun fetchEvNews(
        q: String?,
        from: String?,
        to: String?,
        sortBy: String?,
        qInTitle: String,
        sources: String,
        domains: String,
        excludeDomains: String,
    ) {
        _newsEverythingState.subscribeTo(
            {
                fetchNewsEverythingUseCase(
                    q,
                    from,
                    to,
                    sortBy,
                    qInTitle,
                    sources,
                    domains,
                    excludeDomains,
                )
            },
            { it.map { data -> data.toUI() } }
        )
    }

    fun search(q: String) {
        _search.subscribeTo({
            fetchTopNewsUseCase("", "", "", q)
        }, { it.map { data -> data.toUI() } })
    }
}