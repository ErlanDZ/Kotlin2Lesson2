package com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentMainBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import com.example.kotlin2lesson2.presentation.state.UIState
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.bbcnews.BBCNewsAdapter
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.topheadlinesintheus.TopNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()

    private val topNewsAdapter = TopNewsAdapter()
    private val bbcNewsAdapter = BBCNewsAdapter()

    override fun setupRequests() {
        viewModel.fetchTopNews(
            "us", "", "", "",
        )

        viewModel.fetchCategories(
            "", "", "bbc-news", "",
        )
        setupTopNewsRecycler()
    }

    private fun setupTopNewsRecycler() = with(binding) {
        recyclerViewVerticalTopNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewHorizontal.layoutManager =
            LinearLayoutManager(context)

        recyclerViewVerticalTopNews.adapter = topNewsAdapter

        recyclerViewHorizontal.adapter = bbcNewsAdapter

        setupListener()
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
        viewModel.categoriesState.subscribe {
            when (it) {
                is UIState.Error -> {}
                is UIState.Loading -> {}
                is UIState.Success -> {
                    bbcNewsAdapter.submitList(it.data)
                }
            }
        }
    }

    private fun setupListener() = with(binding) {
        bbcNews.setOnClickListener {
            viewModel.fetchCategories(
                "",
                "",
                "bbc-news",
                "",
            )
        }

        business.setOnClickListener {
            viewModel.fetchCategories(
                "de",
                "business",
                "",
                "",
            )
        }

        trump.setOnClickListener {
            viewModel.fetchCategories(
                "",
                "",
                "",
                "trump",
            )
        }

        bitcoin.setOnClickListener {

        }

        apple.setOnClickListener {

        }

        techCrunch.setOnClickListener {

        }

        theNextWeb.setOnClickListener {

        }
    }
}