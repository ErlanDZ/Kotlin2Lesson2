package com.example.kotlin2lesson2.presentation.ui.fragments.main

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentMainBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import com.example.kotlin2lesson2.presentation.state.UIState
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.TopNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()

    private val topNewsAdapter = TopNewsAdapter()


    override fun setupRequests() {
        viewModel.fetchTopNews()

        setupTopNewsRecycler()
    }

    private fun setupTopNewsRecycler() = with(binding) {
        recyclerViewVerticalTopNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewVerticalTopNews.adapter = topNewsAdapter
    }

    override fun setupObservers() {
        viewModel.topNewsState.subscribe {
            when (it) {
                is UIState.Error -> {
                }
                is UIState.Loading -> {
                }
                is UIState.Success -> {
                    topNewsAdapter.submitList(it.data)
                }
            }
        }
    }
}