package com.example.kotlin2lesson2.presentation.ui.fragments.main.business

import com.example.kotlin2lesson2.domain.usecase.topNews.FetchBusinessUseCase
import com.example.kotlin2lesson2.presentation.base.BaseViewModel
import com.example.kotlin2lesson2.presentation.model.NewsUI
import com.example.kotlin2lesson2.presentation.model.toUI
import com.example.kotlin2lesson2.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(
    private val fetchBusinessUseCase: FetchBusinessUseCase
): BaseViewModel() {
    private val _businessState = MutableStateFlow<UIState<List<NewsUI>>>(UIState.Loading())
    val businessState: StateFlow<UIState<List<NewsUI>>> = _businessState

    fun fetchBusiness() {
        _businessState.subscribeTo(
            { fetchBusinessUseCase() },
            { it.map { data -> data.toUI() } })
    }
}