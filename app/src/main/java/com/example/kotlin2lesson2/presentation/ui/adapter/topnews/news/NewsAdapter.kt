package com.example.kotlin2lesson2.presentation.ui.adapter.topnews.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.NewsItemBinding
import com.example.kotlin2lesson2.presentation.base.BaseComparator
import com.example.kotlin2lesson2.presentation.model.NewsUI

class NewsAdapter(
    private val itemClick: (item: NewsUI) -> Unit,
) : ListAdapter<NewsUI, NewsAdapter.NewsViewHolder>(
    BaseComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    inner class NewsViewHolder(
        private val binding: NewsItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener{
                getItem(absoluteAdapterPosition)?.let {
                    itemClick(it)
                }
            }
        }

        fun onBind(news: NewsUI) = with(binding) {
            publishedAt.text = news.publishedAt
            titleNews.text = news.title
            if (news.source.name == "") {
                val users = "User"
                userNews.text = users
            } else {
                userNews.text = news.author
            }
            if (news.urlToImage == null) {
                imageNews.setImageResource(R.drawable.news_image)
            } else {
                imageNews.load(news.urlToImage)
            }
        }
    }
}
