package com.example.kotlin2lesson2.presentation.ui.fragments.main

import com.example.kotlin2lesson2.domain.usecase.FetchTopNewsUseCase
import com.example.kotlin2lesson2.presentation.base.BaseViewModel
import com.example.kotlin2lesson2.presentation.model.TopNewsUI
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

    private val _topNewsState = MutableStateFlow<UIState<List<TopNewsUI>>>(UIState.Loading())
    val topNewsState: StateFlow<UIState<List<TopNewsUI>>> = _topNewsState

    fun fetchTopNews() {
        _topNewsState.subscribeTo(
            { fetchTopNewsUseCase() },
            { it.map { data -> data.toUI() } })
    }
}