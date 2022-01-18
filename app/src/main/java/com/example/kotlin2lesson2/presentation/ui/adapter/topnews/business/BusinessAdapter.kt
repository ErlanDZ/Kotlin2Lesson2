package com.example.kotlin2lesson2.presentation.ui.adapter.topnews.business

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin2lesson2.databinding.NewsItemBinding
import com.example.kotlin2lesson2.presentation.base.BaseComparator
import com.example.kotlin2lesson2.presentation.model.NewsUI

class BusinessAdapter : ListAdapter<NewsUI, BusinessAdapter.NewsViewHolder>(
    BaseComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            NewsItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    class NewsViewHolder(
        private val binding: NewsItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(news: NewsUI) = with(binding) {
            imageNews.load(news.urlToImage)
            publishedAt.text = news.publishedAt
            titleNews.text = news.title
            if (news.source.name == "") {
                val users = "User"
                userNews.text = users
            } else {
                userNews.text = news.author
            }
        }
    }
}
