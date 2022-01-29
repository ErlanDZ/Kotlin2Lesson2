package com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews.search

import android.os.Handler
import android.os.Looper
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentSearchBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import com.example.kotlin2lesson2.presentation.model.NewsUI
import com.example.kotlin2lesson2.presentation.state.UIState
import com.example.kotlin2lesson2.presentation.ui.adapter.topnews.search.SearchAdapter
import com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding, MainViewModel>(R.layout.fragment_search) {

    override val binding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel: MainViewModel by viewModels()
    private val searchAdapter = SearchAdapter(
        this::setOnItemClickListener
    )
    private var currentText = ""
    private val handler = Handler(Looper.getMainLooper())
    private val searchRunnable = Runnable {
        viewModel.search(currentText)
    }

    override fun initialize() {
        setupSearchRecycler()
    }

    private fun setupSearchRecycler() {
        binding.recyclerSearch.layoutManager =
            LinearLayoutManager(context)

        binding.recyclerSearch.adapter = searchAdapter
    }

    override fun setupRequests() {
        binding.etSearch.doAfterTextChanged {
            currentText = it?.toString() ?: ""
            handler.removeCallbacks(searchRunnable)
            handler.postDelayed(searchRunnable, 500L)
        }
    }

    override fun setupObservers() {
        viewModel.search.subscribe {
            when (it) {
                is UIState.Error -> {}
                is UIState.Loading -> {}
                is UIState.Success -> {
                    searchAdapter.submitList(it.data)
                }
            }
        }
    }

    private fun setOnItemClickListener(id: NewsUI) {}
}