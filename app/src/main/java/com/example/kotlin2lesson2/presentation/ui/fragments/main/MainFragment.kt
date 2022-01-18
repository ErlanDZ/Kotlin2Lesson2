package com.example.kotlin2lesson2.presentation.ui.fragments.main

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentMainBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import com.example.kotlin2lesson2.presentation.state.UIState
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.bbcnews.BBCNewsAdapter
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.business.BusinessAdapter
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.topheadlinesintheus.TopNewsAdapter
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.trump.TrumpAdapter
import com.example.kotlin2lesson2.presentation.ui.fragments.main.bbcnews.BBCNewsViewModel
import com.example.kotlin2lesson2.presentation.ui.fragments.main.business.BusinessViewModel
import com.example.kotlin2lesson2.presentation.ui.fragments.main.topheadlinesintheus.MainViewModel
import com.example.kotlin2lesson2.presentation.ui.fragments.main.trump.TrumpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()
    private val bbcNewsViewModel: BBCNewsViewModel by viewModels()
    private val businessViewModel: BusinessViewModel by viewModels()
    private val trumpViewModel: TrumpViewModel by viewModels()

    private val topNewsAdapter = TopNewsAdapter()
    private val bbcNewsAdapter = BBCNewsAdapter()
    private val businessAdapter = BusinessAdapter()
    private val trumpAdapter = TrumpAdapter()

    override fun setupRequests() {
        viewModel.fetchTopNews()
        setupTopNewsRecycler()
    }

    private fun setupTopNewsRecycler() = with(binding) {
        recyclerViewVerticalTopNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewHorizontal.layoutManager =
            LinearLayoutManager(context)

        recyclerViewVerticalTopNews.adapter = topNewsAdapter

        recyclerViewHorizontal.adapter = bbcNewsAdapter
        bbcNewsViewModel.fetchBBCNews()

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

            bbcNewsViewModel.bbcNewsState.subscribe {
                when (it) {
                    is UIState.Error -> {

                    }
                    is UIState.Loading -> {

                    }
                    is UIState.Success -> {
                        bbcNewsAdapter.submitList(it.data)
                    }
                }
            }

        businessViewModel.businessState.subscribe {
            when (it) {
                is UIState.Error -> {

                }
                is UIState.Loading -> {

                }
                is UIState.Success -> {
                    businessAdapter.submitList(it.data)
                }
            }
        }

        trumpViewModel.trumpState.subscribe {
            when (it) {
                is UIState.Error -> {

                }
                is UIState.Loading -> {

                }
                is UIState.Success -> {
                    trumpAdapter.submitList(it.data)
                }
            }
        }
    }

    private fun setupListener() = with(binding) {
        bbcNews.setOnClickListener {
            recyclerViewHorizontal.adapter = bbcNewsAdapter
            bbcNewsViewModel.fetchBBCNews()
        }

        business.setOnClickListener {
            recyclerViewHorizontal.adapter = businessAdapter
            businessViewModel.fetchBusiness()
        }

        trump.setOnClickListener {
            recyclerViewHorizontal.adapter = trumpAdapter
            trumpViewModel.fetchTrump()
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