package com.example.kotlin2lesson2.presentation.ui.fragments.main.bbcnews

import com.example.kotlin2lesson2.domain.usecase.topNews.FetchBBCNewsRepositoryUseCase
import com.example.kotlin2lesson2.presentation.base.BaseViewModel
import com.example.kotlin2lesson2.presentation.model.NewsUI
import com.example.kotlin2lesson2.presentation.model.toUI
import com.example.kotlin2lesson2.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BBCNewsViewModel @Inject constructor(
    private val fetchBBCNewsRepositoryUseCase: FetchBBCNewsRepositoryUseCase,
) : BaseViewModel() {
    private val _newsState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val bbcNewsState: StateFlow<UIState<List<NewsUI>>> = _newsState

    fun fetchBBCNews() {
        _newsState.subscribeTo(
            { fetchBBCNewsRepositoryUseCase() },
            { it.map { data -> data.toUI() } })
    }
}