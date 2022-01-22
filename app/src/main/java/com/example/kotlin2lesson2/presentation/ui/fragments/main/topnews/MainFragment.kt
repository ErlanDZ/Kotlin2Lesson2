package com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentMainBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import com.example.kotlin2lesson2.presentation.state.UIState
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.news.NewsAdapter
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.topheadlinesintheus.TopNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()

    private val topNewsAdapter = TopNewsAdapter()
    private val newsAdapter = NewsAdapter()

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

        recyclerViewHorizontal.adapter = newsAdapter


        setupListener()
    }

    override fun setupObservers() {

        viewModel.topNewsState.subscribe {
            when (it) {
                is UIState.Error -> {
                }
                is UIState.Loading -> {
                    binding.recyclerViewVerticalTopNews.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                is UIState.Success -> {
                    binding.recyclerViewVerticalTopNews.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    topNewsAdapter.submitList(it.data)
                }
            }
        }

        viewModel.categoriesState.subscribe {
            when (it) {
                is UIState.Error -> {}
                is UIState.Loading -> {
                    binding.recyclerViewHorizontal.visibility = View.GONE
                    binding.progressBar2.visibility = View.VISIBLE
                }
                is UIState.Success -> {
                    binding.recyclerViewHorizontal.visibility = View.VISIBLE
                    binding.progressBar2.visibility = View.GONE
                    newsAdapter.submitList(it.data)
                }
            }
        }

        viewModel.newsEverythingState.subscribe {
            when (it) {
                is UIState.Error -> {}
                is UIState.Loading -> {
                    binding.recyclerViewHorizontal.visibility = View.GONE
                    binding.progressBar2.visibility = View.VISIBLE
                }
                is UIState.Success -> {
                    binding.recyclerViewHorizontal.visibility = View.VISIBLE
                    binding.progressBar2.visibility = View.GONE
                    newsAdapter.submitList(it.data)
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
            viewModel.fetchEvNews(
                "bitcoin",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
            )
        }

        apple.setOnClickListener {
            viewModel.fetchEvNews(
                "apple",
                "2022-01-17",
                "2022-01-17",
                "popularity",
                "",
                "",
                "",
                "",
            )
        }

        techCrunch.setOnClickListener {
            viewModel.fetchEvNews(
                "",
                "",
                "",
                "",
                "",
                "",
                "techcrunch.com,thenextweb.com",
                "",
            )
        }
    }
}