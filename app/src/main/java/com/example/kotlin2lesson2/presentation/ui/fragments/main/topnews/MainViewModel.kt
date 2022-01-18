package com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews

import com.example.kotlin2lesson2.domain.usecase.topNews.FetchTopNewsUseCase
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
) : BaseViewModel() {

    private val _topNewsState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val topNewsState: StateFlow<UIState<List<NewsUI>>> = _topNewsState

    private val _categoriesState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val categoriesState: StateFlow<UIState<List<NewsUI>>> = _categoriesState

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
}