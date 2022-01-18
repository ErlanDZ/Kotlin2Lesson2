package com.example.kotlin2lesson2.presentation.ui.fragments.main.trump

import com.example.kotlin2lesson2.domain.usecase.topNews.FetchHeadlinesAboutTrumpUseCase
import com.example.kotlin2lesson2.presentation.base.BaseViewModel
import com.example.kotlin2lesson2.presentation.model.NewsUI
import com.example.kotlin2lesson2.presentation.model.toUI
import com.example.kotlin2lesson2.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TrumpViewModel @Inject constructor(
    private val fetchTrumpUseCase: FetchHeadlinesAboutTrumpUseCase
): BaseViewModel() {
    private val _trumpState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val trumpState: StateFlow<UIState<List<NewsUI>>> = _trumpState

    fun fetchTrump() {
        _trumpState.subscribeTo(
            { fetchTrumpUseCase() },
            { it.map { data -> data.toUI() } })
    }
}