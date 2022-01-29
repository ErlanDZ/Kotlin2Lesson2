package com.example.kotlin2lesson2.presentation.ui.adapter.topnews.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin2lesson2.databinding.SearchItemBinding
import com.example.kotlin2lesson2.presentation.base.BaseComparator
import com.example.kotlin2lesson2.presentation.model.NewsUI

class SearchAdapter(private val onItemClick: (id: NewsUI) -> Unit) :
    ListAdapter<NewsUI, SearchAdapter.SearchViewHolder>(
        BaseComparator()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class SearchViewHolder(
        private val binding: SearchItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(news: NewsUI) = with(binding) {
            imgSearch.load(news.urlToImage)
            titleSearch.text = news.title
        }

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    onItemClick(it)
                }
            }
        }
    }
}