package com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentMainBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import com.example.kotlin2lesson2.presentation.model.NewsUI
import com.example.kotlin2lesson2.presentation.state.UIState
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.news.NewsAdapter
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.topheadlinesintheus.TopNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()

    private val topNewsAdapter = TopNewsAdapter(this::onItemClick)
    private val newsAdapter = NewsAdapter(this::onItemCategoriesClick)

    override fun setupRequests() {
        viewModel.fetchTopNews(
            "us", "", "", "", 1
        )

        viewModel.fetchCategories(
            "", "", "bbc-news", "", 1)
        setupTopNewsRecycler()
    }

    private fun setupTopNewsRecycler() {
        recyclerViewVertical()
        recyclerViewHorizontal()
        setupListener()
    }

    override fun setupObservers() {
        breakingNews()
        categoriesNews()
        categoriesEverythingNews()
    }

    private fun setupListener() {
        bbcNews()
        business()
        trump()
        bitcoin()
        apple()
        techCrunch()
    }

    private fun onItemClick(item: NewsUI) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToDetailedFragment(item)
        )
    }

    private fun onItemCategoriesClick(item: NewsUI) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToDetailedFragment(item)
        )
    }

    private fun recyclerViewVertical() = with(binding) {
        recyclerViewVerticalTopNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewVerticalTopNews.adapter = topNewsAdapter
        PagerSnapHelper().attachToRecyclerView(recyclerViewVerticalTopNews)
    }

    private fun recyclerViewHorizontal() = with(binding) {
        recyclerViewHorizontal.layoutManager =
            LinearLayoutManager(context)
        recyclerViewHorizontal.adapter = newsAdapter
    }

    private fun breakingNews() {
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
    }

    private fun categoriesNews() {
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
    }

    private fun categoriesEverythingNews() {
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

    private fun bbcNews() = with(binding) {
        bbcNews.setOnClickListener {
            viewModel.fetchCategories(
                "", "", "bbc-news", "", 1
            )
        }
    }

    private fun business() = with(binding) {
        business.setOnClickListener {
            viewModel.fetchCategories(
                "de",
                "business",
                "",
                "", 1
            )
        }

    }

    private fun trump() = with(binding) {
        trump.setOnClickListener {
            viewModel.fetchCategories(
                "",
                "",
                "",
                "trump", 1
            )
        }

    }

    private fun bitcoin() = with(binding) {
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

    }

    private fun apple() = with(binding) {
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

    }

    private fun techCrunch() = with(binding) {
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